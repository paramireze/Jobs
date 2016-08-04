package jobs

import grails.plugin.springsecurity.annotation.Secured

@Secured("permitAll")
class HomeController {

    def index = {
        def users = User.findAll()
        def jobPosts = JobPost.findAll()
        List categories = Category.findAll()

        [jobPosts: jobPosts, categories: categories]

    }
}
