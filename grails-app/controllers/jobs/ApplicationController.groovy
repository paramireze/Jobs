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
        User user = springSecurityService.currentUser
        // left off here. Check roles
        def application = Application.findByUser(user)
        def applications = Application.list()
        respond Application.list(params), model: [applicationInstanceCount: Application.count()]
    }

    def show(Application applicationInstance) {
        respond applicationInstance
    }

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

    @Transactional
    def save() {
        def applicationInstance = new Application()
        applicationInstance.user = springSecurityService.currentUser as User

        if (params.documentResume) {
            applicationInstance.resume = Document.findByTitle(params.documentResume)
        }

        if (params.documentCoverletter) {
            applicationInstance.coverLetter = Document.findByTitle(params.documentCoverletter)
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
                flash.message = "Application has been submitted."
                redirect(action: "index")            }
            '*' { respond applicationInstance, [status: CREATED] }
        }
    }

    def edit(Application applicationInstance) {
        respond applicationInstance
    }

    @Transactional
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
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Application.label', default: 'Application'), applicationInstance.id])
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
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Application.label', default: 'Application'), applicationInstance.id])
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
