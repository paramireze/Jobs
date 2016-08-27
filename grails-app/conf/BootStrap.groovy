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

        User paul = new User('Paul Ramirez', 'password', 'paul@gmail.com', '608-445-4444', 'East Washington Ave', 'Madison', 'WI', '53703')
        User bryan =  new User('Bryan Smith', 'password', 'bryan@herzing.edu', '608-245-5555', 'West Washington Ave', 'Madison', 'WI', '53703')
        User elizabeth =  new User('Elizabeth Stevens', 'password', 'elizabeth@wisc.edu', '608-593-2492', 'State St.', 'Madison', 'WI', '58242')
        User arseny =  new User('Arseny Hall', 'password', 'arseny@gmail.com', '608-345-2424', 'juniper st', 'Madison', 'WI', '53532')

        baseline.addAll(paul,bryan,elizabeth,arseny)

        baseline << new UserRole(paul, hr)
        baseline << new UserRole(bryan, user)
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

        def paulDocumentITResume = new Document(documentTypeResume, paul, 'IT Resume For Software Developer',                   '<h2>What is Lorem Ipsum?</h2>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')
        def paulDocumentHelpDeskResume = new Document(documentTypeResume, paul, 'Help Desk Resume',                             '<h2>What is Lorem Ipsum?</h2>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')
        def paulDocumentITCoverLetter= new Document(documentTypeCoverLetter, paul, 'IT Cover Letter for Software Developer',    '<h2>What is Lorem Ipsum?</h2>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')
        def paulDocumentHelpDeskCoverLetter = new Document(documentTypeCoverLetter, paul, 'Help Desk Cover Letter',             '<h2>What is Lorem Ipsum?</h2>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')

        def bryanDocumentITResume = new Document(documentTypeResume, bryan, 'IT Resume For Software Developer',                 '<h2>What is Lorem Ipsum?</h2>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')
        def bryanDocumentHelpDeskResume = new Document(documentTypeResume, bryan, 'Help Desk Resume',                           '<h2>What is Lorem Ipsum?</h2>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')
        def bryanDocumentITCoverLetter= new Document(documentTypeCoverLetter, bryan, 'IT Cover Letter for Software Developer',  '<h2>What is Lorem Ipsum?</h2>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')
        def bryanDocumentHelpDeskCoverLetter = new Document(documentTypeCoverLetter, bryan, 'Help Desk Cover Letter',           '<h2>What is Lorem Ipsum?</h2>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')

        baseline.addAll(paulDocumentITResume, paulDocumentHelpDeskResume, paulDocumentITCoverLetter, paulDocumentHelpDeskCoverLetter)
        baseline.addAll(bryanDocumentITResume, bryanDocumentHelpDeskResume, bryanDocumentITCoverLetter, bryanDocumentHelpDeskCoverLetter)


        Job jobSoftWareDeveloper = new Job('Software Developer', informationTechnology, 'A software developer is a person concerned with facets of the software development process, including the research, design, programming, and testing of computer software')
        Job jobHelpDesk = new Job('Help Desk', informationTechnology,'a service providing information and support to computer users, especially within a company.')
        Job jobFinanceSpecialist = new Job('Finance Specialist', finance, 'Responsible for salary and other expenses' )
        Job jobHumanResourceDirector = new Job('Human Resource Director', humanResources, 'Human resources are the people who make up the workforce of an organization, business sector, or economy. "Human capital" is sometimes used ...')
        Job jobNurse = new Job('Nurse', healthCare, 'Nursing is a profession within the health care sector focused on the care of individuals, families, and communities so they may attain, maintain, or recover optimal health and quality of life.')
        Job jobResidentAssistant = new Job('Resident Assistant', healthCare, '')

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

        Application paulsITApplication = new Application(paul, softwareDev, paulDocumentITResume, paulDocumentITCoverLetter, statusNew, '')
        Application paulsHelpDeskApplication = new Application(paul, helpDeskSupport, paulDocumentHelpDeskResume, paulDocumentHelpDeskCoverLetter, statusNew, '')
        Application bryanApplication = new Application(bryan, nurseProfessional, bryanDocumentITResume, bryanDocumentITCoverLetter, statusNew, '')
        Application bryanApplication2 = new Application(bryan, residentAssistant, bryanDocumentHelpDeskResume, bryanDocumentHelpDeskCoverLetter, statusNew, '')
        Application bryanApplication3 = new Application(bryan, hrStaff, bryanDocumentHelpDeskResume, bryanDocumentITCoverLetter, statusNew, '')

        baseline.addAll(paulsITApplication, paulsHelpDeskApplication, bryanApplication, bryanApplication2, bryanApplication3)


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
