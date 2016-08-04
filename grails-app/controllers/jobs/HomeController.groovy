package jobs

import grails.plugin.springsecurity.annotation.Secured

@Secured("permitAll")
class HomeController {

    def index = {
        def users = User.findAll()
        def jobPosts = JobPost.findAll()
        List categories = jobPosts.job.category.unique()

        [jobPosts: jobPosts, categories: categories]

    }
}
