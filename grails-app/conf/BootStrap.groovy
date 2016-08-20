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

        User paul = new User('Paul Ramirez', 'password', 'paul@gmail.com')
        User bryan =  new User('Bryan Giant', 'password', 'bryan@herzing.edu')
        User elizabeth =  new User('Elizabeth Stevens', 'password', 'elizabeth@wisc.edu')
        User arseny =  new User('Arseny Hall', 'password', 'arseny@gmail.com')

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

        def documentTypeResume = new DocumentType('Resume')
        def documentTypeCoverLetter = new DocumentType('Coverletter')
        def documentTypeThankYou = new DocumentType('Thank You Letter')
        def documentTypeFollowUp = new DocumentType('Follow Up')

        baseline.addAll(documentTypeResume, documentTypeCoverLetter, documentTypeThankYou, documentTypeFollowUp)

        def paulDocumentITResume = new Document(documentTypeResume, paul, 'ITResume', 'this is the body of the entire resume')
        def paulDocumentHelpDeskResume = new Document(documentTypeResume, paul, 'HelpDeskResume', 'this is the body of the entire resume')
        def paulDocumentITCoverLetter= new Document(documentTypeCoverLetter, paul, 'ITCoverLetter', 'this is the body of the entire resume number two')
        def paulDocumentHelpDeskCoverLetter = new Document(documentTypeCoverLetter, paul, 'HelpDeskCoverLetter', 'this is the body of the entire resume number two')

        baseline.addAll(paulDocumentITResume, paulDocumentHelpDeskResume, paulDocumentITCoverLetter, paulDocumentHelpDeskCoverLetter)


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

        Application paulsITApplication = new Application(paul, softwareDev, paulDocumentITResume, paulDocumentITCoverLetter, statusNew)
        Application paulsHelpDeskApplication = new Application(paul, helpDeskSupport, paulDocumentHelpDeskResume, paulDocumentHelpDeskCoverLetter, statusNew)
        //Application bryanApplication = new Application(bryan, nurseProfessional, statusOffer)
        //Application bryanApplication2 = new Application(bryan, residentAssistant, statusRejected)
        //Application bryanApplication3 = new Application(bryan, hrStaff, statusNew)

        baseline.addAll(paulsITApplication, paulsHelpDeskApplication)


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
