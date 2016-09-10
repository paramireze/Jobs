package jobs

import grails.converters.JSON
import grails.converters.XML
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured("hasRole('ROLE_HR')")
class ApplicationController {

    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured("hasAnyRole('ROLE_HR','ROLE_USER')")
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        User user = springSecurityService.currentUser as User

        Role hr = Role.findById(2)
        // left off here. Check roles
        def applicationInstanceList = user.hasRole(hr)? Application.list():  Application.findAllByUser(user)

        [user:user, applicationInstanceCount: Application.count(), applicationInstanceList: applicationInstanceList]
    }

    @Secured("hasAnyRole('ROLE_HR','ROLE_USER')")
    def show(Application applicationInstance) {
        if (!applicationInstance && params?.applicationInstanceId) {
            applicationInstance = Application.get(params.applicationInstanceId)
        }

        respond applicationInstance
    }

    @Secured("hasAnyRole('ROLE_HR','ROLE_USER')")
    def create() {
        User user = springSecurityService.currentUser
        DocumentType resume = DocumentType.findByType('Resume')
        DocumentType coverLetter = DocumentType.findByType('Coverletter')

        Collection<Document> resumes = []
        Collection<Document> coverLetters = []

        user?.documents?.each { Document document ->
            if (document.type == resume) {
                resumes << document
            } else if(document.type == coverLetter) {
                coverLetters << document
            }
        }

        Application application = new Application(params)
        application.jobPost = JobPost.get(params.jobPostId)
        def listObject =  [applicationInstance: application, user: user, resumes: resumes, coverLetters: coverLetters]

        withFormat {
            // The view needs more fluff, other responses just get the data
            html { listObject }
            json { render list as JSON }
            xml { render list as XML }
        }
    }

    @Secured("hasAnyRole('ROLE_HR','ROLE_USER')")
    def save() {
        def applicationInstance = new Application()
        applicationInstance.user = springSecurityService.currentUser as User

        if (params.resume) {
            applicationInstance.resume = Document.get(params.resume)
        }

        if (params.coverLetter) {
            applicationInstance.coverLetter = Document.get(params.coverLetter)
        }

        applicationInstance.jobPost = JobPost.get(params.jobPost)
        applicationInstance.status = Status.findByName('new')

        if (applicationInstance == null) {
            notFound()
            return
        }

        if (applicationInstance.hasErrors()) {
            respond applicationInstance.errors, view: 'create'
            return
        }

        applicationInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = "Application has been Submitted."
                redirect(action: "show", params: [applicationInstanceId: applicationInstance.id])}
            '*' { respond applicationInstance, [status: CREATED] }
        }
    }

    @Secured("hasAnyRole('ROLE_HR','ROLE_USER')")
    def edit(Application applicationInstance) {
        User user = springSecurityService.currentUser

        DocumentType resume = DocumentType.findByType('Resume')
        DocumentType coverLetter = DocumentType.findByType('Coverletter')

        Collection<Document> resumes = []
        Collection<Document> coverLetters = []

        user?.documents?.each { Document document ->
            if (document.type == resume) {
                resumes << document
            } else if(document.type == coverLetter) {
                coverLetters << document
            }
        }

        def listObject =  [applicationInstance: applicationInstance, user: user, resumes: resumes, coverLetters: coverLetters]

        withFormat {
            // The view needs more fluff, other responses just get the data
            html { listObject }
            json { render list as JSON }
            xml { render list as XML }
        }
    }

    @Secured("hasAnyRole('ROLE_HR','ROLE_USER')")
    def update(Application applicationInstance) {
        if (applicationInstance == null) {
            notFound()
            return
        }

        if (applicationInstance.hasErrors()) {
            respond applicationInstance.errors, view: 'edit'
            return
        }

        applicationInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = "Your application has been updated"
                redirect applicationInstance
            }
            '*' { respond applicationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Application applicationInstance) {

        if (applicationInstance == null) {
            notFound()
            return
        }

        applicationInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = "Application deleted"
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'application.label', default: 'Application'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
