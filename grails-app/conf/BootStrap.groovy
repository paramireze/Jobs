import jobs.Category
import jobs.DocumentType
import jobs.EmploymentType
import jobs.Job
import jobs.JobPost
import jobs.Role
import jobs.Status
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

        Category informationTechnology = new Category('Information Technology', 'Software/hardware Support and Development')
        Category humanResources = new Category('Human Resources', '')
        Category healthCare = new Category('Healthcare', '')
        Category finance = new Category('Finance', 'Salary and Benefits')
        Category adminstrative = new Category('Administrative', '')

        baseline.addAll(informationTechnology, humanResources, healthCare, finance, adminstrative)

        baseline << new EmploymentType('Full Time')
        baseline << new EmploymentType('Part Time')
        baseline << new EmploymentType('LTE')
        baseline << new EmploymentType('Project Hire')
        baseline << new EmploymentType('Student')

        User paul = new User('paul', 'password').save()
        User bryan =  new User('bryan', 'password')
        User elizabeth =  new User('elizabeth', 'password')
        User arseny =  new User('arseny', 'password')

        baseline.addAll(paul,bryan,elizabeth,arseny)

        baseline << new UserRole(paul, hr)
        baseline << new UserRole(bryan, hr)
        baseline << new UserRole(elizabeth, user)
        baseline << new UserRole(arseny, user)

        baseline << new Status('rejected')
        baseline << new Status('candidate')
        baseline << new Status('finalist')
        baseline << new Status('send offer')
        baseline << new Status('confirmed offer')

        baseline << new DocumentType('Resume')
        baseline << new DocumentType('Coverletter')
        baseline << new DocumentType('Thank You Letter')
        baseline << new DocumentType('Follow Up')

        baseline << new Job('Software Developer', informationTechnology)
        baseline << new Job('Help Desk', informationTechnology)
        baseline << new Job('Finance Specialist', finance)
        baseline << new Job('Human Resource Director', humanResources)
        baseline << new Job('Nurse', healthCare)
        baseline << new Job('Resident Assistant', healthCare)

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
