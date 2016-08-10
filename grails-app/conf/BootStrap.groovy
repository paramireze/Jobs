import jobs.Application
import jobs.Category
import jobs.Document
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

        User paul = new User('paul', 'password', 'paul@gmail.com')
        User bryan =  new User('bryan', 'password', 'bryan@herzing.edu')
        User elizabeth =  new User('elizabeth', 'password', 'elizabeth@wisc.edu')
        User arseny =  new User('arseny', 'password', 'arseny@gmail.com')

        baseline.addAll(paul,bryan,elizabeth,arseny)

        baseline << new UserRole(paul, hr)
        baseline << new UserRole(bryan, hr)
        baseline << new UserRole(elizabeth, user)
        baseline << new UserRole(arseny, user)

        def statusNew = new Status('new')
        def statusRejected = new Status('rejected')
        def statusCandidate = new Status('candidate')
        def statusFinalist = new Status('finalist')
        def statusOffer = new Status('send offer')
        def statusConfirmed = new Status('confirmed offer')

        baseline.addAll(statusNew, statusRejected, statusCandidate, statusFinalist, statusOffer, statusConfirmed)

        def documentResume = new DocumentType('Resume')
        def documentCoverLetter = new DocumentType('Coverletter')
        def documentThankYou = new DocumentType('Thank You Letter')
        def documentFollowUp = new DocumentType('Follow Up')

        baseline.addAll(documentResume, documentCoverLetter, documentThankYou, documentFollowUp)

        baseline << new Document(documentResume, paul, 'ITResume', 'this is the body of the entire resume')
        baseline << new Document(documentCoverLetter, paul, 'ITCoverLetter', 'this is the body of the entire resume number two')




        Job jobSoftWareDeveloper = new Job('Software Developer', informationTechnology)
        Job jobHelpDesk = new Job('Help Desk', informationTechnology)
        Job jobFinanceSpecialist = new Job('Finance Specialist', finance)
        Job jobHumanResourceDirector = new Job('Human Resource Director', humanResources)
        Job jobNurse = new Job('Nurse', healthCare)
        Job jobResidentAssistant = new Job('Resident Assistant', healthCare)

        baseline.addAll(jobSoftWareDeveloper, jobHelpDesk, jobFinanceSpecialist, jobHumanResourceDirector, jobNurse, jobResidentAssistant)

        //job, employmentType, start, end, salaryRange, active (bool)
        JobPost softwareDev = new JobPost(
                job: jobSoftWareDeveloper,
                employmentType: fullTime,
                postStart: 'July 01, 2016',
                postEnd: 'Sept 01, 2016',
                salaryRange: '50,000 - 80,000',
                active: true
        )

        JobPost helpDeskSupport = new JobPost(
                job:jobHelpDesk,
                employmentType: partTime,
                postEnd: 'Oct 01, 2016',
                postStart: 'June 01, 2016',
                salaryRange: '40,000 - 60,000',
                active: true
        )

        JobPost hrStaff = new JobPost(
                job:jobHumanResourceDirector,
                employmentType: fullTime,
                postEnd: 'Oct 01, 2016',
                postStart: 'June 01, 2016',
                salaryRange: '43,000 - 65,000',
                active: true
        )

        JobPost nurseProfessional = new JobPost(
                job:jobNurse,
                employmentType: fullTime,
                postEnd: 'Oct 01, 2016',
                postStart: 'June 01, 2016',
                salaryRange: '44,000 - 95,000',
                active: true
        )

        JobPost residentAssistant = new JobPost(
                job:jobResidentAssistant,
                employmentType: partTime,
                postEnd: 'Oct 11, 2016',
                postStart: 'June 21, 2016',
                salaryRange: '34,000 - 45,000',
                active: true
        )

        baseline.addAll(softwareDev, helpDeskSupport, softwareDev,hrStaff, nurseProfessional, residentAssistant)

        Application paulsApplication = new Application(paul, softwareDev, statusNew)
        Application paulsApplication2 = new Application(paul, helpDeskSupport, statusConfirmed)
        Application bryanApplication = new Application(bryan, nurseProfessional, statusOffer)
        Application bryanApplication2 = new Application(bryan, residentAssistant, statusRejected)
        Application bryanApplication3 = new Application(bryan, hrStaff, statusNew)

        baseline.addAll(paulsApplication, paulsApplication2, bryanApplication, bryanApplication2, bryanApplication3)


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
