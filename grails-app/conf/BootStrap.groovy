import jobs.Role
import jobs.User
import jobs.UserRole

class BootStrap {

    def init = { servletContext ->

        if (User.count > 0) {
            return
        }

        List baseline = []

        Role user = new Role("ROLE_USER")
        Role hr = new Role("ROLE_HR")

        baseline.addAll(user,hr)


        User paul = new User('paul', 'password').save()
        User bryan =  new User('bryan', 'password')
        User elizabeth =  new User('elizabeth', 'password')
        User arseny =  new User('arseny', 'password')

        baseline.addAll(paul,bryan,elizabeth,arseny)

        baseline << new UserRole(paul, hr)
        baseline << new UserRole(bryan, hr)
        baseline << new UserRole(elizabeth, user)
        baseline << new UserRole(arseny, user)


        baseline.each {
            println "saving: $it"
            if (!it.save(flush:true)) {
                println "\t ... failed"
            }

        }

    }
    def destroy = {
    }
}
