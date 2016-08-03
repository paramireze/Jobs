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

        EmploymentType fullTime = new EmploymentType('Full Time')
        EmploymentType partTime = new EmploymentType('Part Time')
        EmploymentType lte = new EmploymentType('LTE')
        EmploymentType project = new EmploymentType('Project')
        EmploymentType student = new EmploymentType('Student')
        EmploymentType internship = new EmploymentType('Internship')

        baseline.addAll(fullTime, partTime, lte, project, student, internship)

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

        Job softwareDeveloper = new Job('Software Developer', informationTechnology)
        Job helpDesk = new Job('Help Desk', informationTechnology)
        Job financialSpec = new Job('Finance Specialist', finance)
        Job humanResourceDirector = new Job('Human Resource Director', humanResources)
        Job nurse = new Job('Nurse', healthCare)
        Job residentAssistant = new Job('Resident Assistant', healthCare)

        baseline.addAll(softwareDeveloper, helpDesk, financialSpec, humanResourceDirector, nurse, residentAssistant)

        //job, employmentType, start, end, salaryRange, active (bool)
        JobPost softwareDev = new JobPost(
                job: softwareDeveloper,
                employmentType: fullTime,
                postStart: 'July 01, 2016',
                postEnd: 'Sept 01, 2016',
                salaryRange: '50,000 - 80,000',
                active: true
        )

        JobPost support = new JobPost(
                job:helpDesk,
                employmentType: partTime,
                postEnd: 'Oct 01, 2016',
                postStart: 'June 01, 2016',
                salaryRange: '40,000 - 60,000',
                active: true
        )

        JobPost hrStaff = new JobPost(
                job:humanResourceDirector,
                employmentType: fullTime,
                postEnd: 'Oct 01, 2016',
                postStart: 'June 01, 2016',
                salaryRange: '43,000 - 65,000',
                active: true
        )

        JobPost nurseProfessional = new JobPost(
                job:nurse,
                employmentType: fullTime,
                postEnd: 'Oct 01, 2016',
                postStart: 'June 01, 2016',
                salaryRange: '44,000 - 95,000',
                active: true
        )
        JobPost residentAss = new JobPost(
                job:residentAssistant,
                employmentType: partTime,
                postEnd: 'Oct 11, 2016',
                postStart: 'June 21, 2016',
                salaryRange: '34,000 - 45,000',
                active: true
        )

        baseline.addAll(softwareDev, support, softwareDev,hrStaff, nurseProfessional, residentAss)

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
