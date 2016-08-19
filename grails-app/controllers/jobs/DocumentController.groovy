package jobs

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured("hasRole('ROLE_HR')")
class DocumentController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured("hasAnyRole('ROLE_HR','ROLE_USER')")
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Document.list(params), model: [documentInstanceCount: Document.count()]
    }

    @Secured("hasAnyRole('ROLE_HR','ROLE_USER')")
    def show(Document documentInstance) {
        respond documentInstance
    }

    @Secured("hasAnyRole('ROLE_HR','ROLE_USER')")
    def create() {
        User user = User.get(params.userId)
        DocumentType documentType = Document.findByTitle(params.documentType)
        respond new Document(params)
    }

    @Transactional
    def save(Document documentInstance) {
        if (documentInstance == null) {
            notFound()
            return
        }

        if (documentInstance.hasErrors()) {
            respond documentInstance.errors, view: 'create'
            return
        }

        documentInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'document.label', default: 'Document'), documentInstance.id])
                redirect documentInstance
            }
            '*' { respond documentInstance, [status: CREATED] }
        }
    }

    def edit(Document documentInstance) {
        respond documentInstance
    }

    @Transactional
    def update(Document documentInstance) {
        if (documentInstance == null) {
            notFound()
            return
        }

        if (documentInstance.hasErrors()) {
            respond documentInstance.errors, view: 'edit'
            return
        }

        documentInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = "<b>Success</b> Document Updated"
                redirect documentInstance
            }
            '*' { respond documentInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Document documentInstance) {

        if (documentInstance == null) {
            notFound()
            return
        }

        documentInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Document.label', default: 'Document'), documentInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'document.label', default: 'Document'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
