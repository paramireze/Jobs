package jobs

import grails.plugin.springsecurity.annotation.Secured

@Secured("permitAll")
class HomeController {

    def index = {
        def users = User.findAll()
        render 'hi'
    }
}
