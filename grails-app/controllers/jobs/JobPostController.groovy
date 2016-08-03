package jobs

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured("permitAll")
class JobPostController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond JobPost.list(params), model: [jobPostInstanceCount: JobPost.count()]
    }

    def show(JobPost jobPostInstance) {
        respond jobPostInstance
    }

    def create() {
        respond new JobPost(params)
    }

    @Transactional
    def save(JobPost jobPostInstance) {
        if (jobPostInstance == null) {
            notFound()
            return
        }

        if (jobPostInstance.hasErrors()) {
            respond jobPostInstance.errors, view: 'create'
            return
        }

        jobPostInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'jobPost.label', default: 'JobPost'), jobPostInstance.id])
                redirect jobPostInstance
            }
            '*' { respond jobPostInstance, [status: CREATED] }
        }
    }

    def edit(JobPost jobPostInstance) {
        respond jobPostInstance
    }

    @Transactional
    def update(JobPost jobPostInstance) {
        if (jobPostInstance == null) {
            notFound()
            return
        }

        if (jobPostInstance.hasErrors()) {
            respond jobPostInstance.errors, view: 'edit'
            return
        }

        jobPostInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'JobPost.label', default: 'JobPost'), jobPostInstance.id])
                redirect jobPostInstance
            }
            '*' { respond jobPostInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(JobPost jobPostInstance) {

        if (jobPostInstance == null) {
            notFound()
            return
        }

        jobPostInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'JobPost.label', default: 'JobPost'), jobPostInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'jobPost.label', default: 'JobPost'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
