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

        def paulDocumentITResume = new Document(documentTypeResume, paul, 'IT Resume For Software Developer', '<p><strong>Paul Ramirez</strong><br />'
                + '1002 Main Street<br />'
                + 'Madison, WI 75026<br />'
                + 'Home: 972.952.7002 | securitywizard@myisp.net</p>'
                + '<p><strong>Information Technology Security Specialist</strong></p>'
                + '<p>Insightful, results-driven IT professional with notable success directing a broad range of corporate IT security initiatives while participating in planning, analyzing, and implementing solutions in support of business objectives. Excel at providing comprehensive secure network design, systems analysis, and full lifecycle project management. Hands-on experience leading all stages of system development efforts, including requirements definition, design, architecture, testing, and support. Outstanding project and program leader; able to coordinate and direct all phases of project-based efforts while managing, motivating, and guiding teams.</p>'
                + '<p>Areas of Expertise</p>'
                + '<ul>'
                + '<li>Network and Systems Security</li>'
                + '<li>Research and Development</li>'
                + '<li>Regulatory Compliance</li>'
                + '<li>Cost Benefits Analysis</li>'
                + '<li>Policy Planning / Implementation</li>'
                + '</ul>'
                + '<ul>'
                + '<li>Virtualization &amp; Cloud Technologies</li>'
                + '<li>Data Integrity / Disaster Recovery</li>'
                + '<li>Risk Assessment / Impact Analysis</li>'
                + '<li>Technical Specifications Development</li>'
                + '<li>Team and Project Leadership</li>'
                + '</ul>'
                + '<p>Technical Proficiencies</p>'
                + '<table style="width:791px">'
                + '<tbody>'
                + '<tr>'
                + '<td>'
                + '<p>Platforms:</p>'
                + '</td>'
                + '<td>'
                + '<p>Windows 7/8/8.1/10, Windows Server 2012 R2, UNIX (Solaris, HP-UX), Linux (Red Hat, Ubuntu), Mac OS, Android, iOS</p>'
                + '</td>'
                + '</tr>'
                + '<tr>'
                + '<td>'
                + '<p>Networking:</p>'
                + '</td>'
                + '<td>'
                + '<p>LAN / WAN Administration, VPN, TCP/IP, Novell, SMS/SQL, 100BaseT Ethernet, SecureID, Cisco Routers &amp; Switches, Juniper Switches, VoIP</p>'
                + '</td>'
                + '</tr>'
                + '<tr>'
                + '<td>'
                + '<p>Languages:</p>'
                + '</td>'
                + '<td>'
                + '<p>C, C++, HTML/HTML 5, Java, JavaScript, PHP, CSS</p>'
                + '</td>'
                + '</tr>'
                + '<tr>'
                + '<td>'
                + '<p>Tools:</p>'
                + '</td>'
                + '<td>'
                + '<p>MS PowerShell, N-Able, Citrix, AutoDesk QTO, Symantec Endpoint Protection, ESET, Command Workstation, VMware, MS Hyper-V, LogMeIn, UltraVNC, Microsoft Office Suite, Access, MS Project</p>'
                + '</td>'
                + '</tr>'
                + '</tbody>'
                + '</table>'
                + '<p>&nbsp;</p>'
                + '<p>Professional Experience</p>'
                + '<p><strong>Systems International</strong>, Dallas, Texas 6/2009 - Present</p>'
                + '<p><strong>Information Security Analyst</strong></p>'
                + '<p>Recruited to establish enterprise-wide information-security program; oversee companywide efforts to identify and evaluate all critical systems. Design and implement security processes and procedures and perform cost benefit analysis on all recommended strategies; accountable for security budget of $1.1 million. Collaborate with external auditors to conduct in-depth compliance audits and penetration testing, presenting results to senior management. Develop curricula and facilitate awareness training. Supervise daily activities of Computer Security Assistant and Internet Administrator.</p>'
                + '<p>Key Achievements:</p>'
                + '<ul>'
                + '<li>Instrumental in developing and implementing Business Continuity and Disaster Recovery (BCP &amp; DRP) Plans for corporate sites throughout Texas, Ohio and Canada.</li>'
                + '<li>Spearheaded creation of four new information-security departments: Risk Assessment, Vulnerability, Penetration Testing, and Security Engineering services.</li>'
                + '<li>Hand selected employees from Information Technology department to build Risk Assessment Team charged with analyzing all critical systems, developing reports to document system vulnerabilities, and recommending appropriate solutions.</li>'
                + '<li>Created company policies and procedures governing corporate security, email and Internet usage, access control, and incident response.</li>'
                + '</ul>'
                + '<p><strong>LLCA Information Systems</strong>, Garland, Texas 3/2002 - 6/2009</p>'
                + '<p><strong>QA Lead</strong>, 1/2005 &ndash; 6/2009</p>'
                + '<p>Promoted to lead system development and new product QA. Ensured accurate release testing for all new applications, providing final approval for bug-free, fully functional commercial solutions. Proactively assigned resources to meet workflow needs. Created development plans, project documentation, and test cases.</p>'
                + '<p>Key Achievements:</p>'
                + '<ul>'
                + '<li>Authored numerous ISO 9000 procedures and security policies in support of engineering operations, participating in regular audits to ensure regulatory compliance.</li>'
                + '<li>Managed creation of high-profile HATP (High Availability Transaction Processing) solution, supervising development teams working in multiple locations.</li>'
                + '<li>Developed highly effective Software Manager application to enable disk-free software upgrades deployed through ATMs and desktop systems worldwide.</li>'
                + '<li>Successfully applied for US Patent on new security software design.</li>'
                + '</ul>'
                + '<p><strong>Computer System Engineer/Network Developer</strong>, 3/2003 &ndash; 1/2005</p>'
                + '<p>Provided remote and on-site support for domestic and international customers, including Tier-III support for LAN/WAN products and sales support for key accounts of all sizes.</p>'
                + '<p>Key Achievements:</p>'
                + '<ul>'
                + '<li>Designed and implemented customer call-center support procedures and customer network design strategy for sales and marketing teams.</li>'
                + '<li>Recognized for outstanding quality of customer service with numerous customer-support awards and personal commendation from clients.&nbsp;</li>'
                + '</ul>'
                + '<p>Education &amp; Credentials</p>'
                + '<p><strong>Bachelor of Science in Computer Information Systems</strong></p>'
                + '<p>University of Texas at Dallas, Dallas, Texas</p>'
                + '<p><strong>Professional Certification</strong></p>'
                + '<ul>'
                + '<li>MCSE &ndash; Microsoft Certified Systems Engineer</li>'
                + '<li>CISSP &ndash;&nbsp;Certified Information Systems Security Professional</li>'
                + '</ul>'
                + '<p><strong>Professional Affiliations</strong></p>'
                + '<ul>'
                + '<li>Information Systems Security Association</li>'
                + '<li>International Information Systems Security Certification Consortium, Inc.</li>'
                + '</ul>')
        def paulDocumentHelpDeskResume = new Document(documentTypeResume, paul, 'Help Desk Resume',                             '<p><strong>Paul Ramirez</strong><br />'
                + '1405 Columbia Ave., Apt. #17<br />'
                + 'Sometown, OH 43085<br />'
                + 'Home: 555-555-5555 | dj@somedomain.com | BeFound Profile<br />'
                + '@twitterhandle | LinkedIn | Portfolio Link</p>'
                + '<p><strong>Help Desk / Web Developer</strong></p>'
                + '<ul>'
                + '<li>Junior Web developer able to build a Web presence from the ground up -- from concept, navigation, layout and programming to UX and SEO.</li>'
                + '<li>Fast learner, hard worker and team player who is proficient in an array of scripting languages and multimedia Web tools.</li>'
                + '</ul>'
                + '<p><strong>Technical Toolbox</strong></p>'
                + '<p><strong>Languages:</strong>&nbsp;Proficient in JavaScript, CSS, HTML, XHTML, Java, .Net and Python.<br />'
                + '<strong>Adobe Suite:</strong>&nbsp;Skilled in Adobe CS5.5 Web Premium -- Dreamweaver, Flash Catalyst, Flash Professional, Flash Builder, Photoshop, Illustrator, Acrobat X Pro, Fireworks, Contribute, Bridge, Device Central and Media Encoder.<br />'
                + '<strong>Additional Web Tools:</strong>&nbsp;Skilled in Rich Internet Applications including Flash, Flex, AIR and JavaFX. Experienced in using REST, SOAP and XML. Familiar with FrontPage, Webtrends and validation tools.</p>'
                + '<p>Education</p>'
                + '<p><strong>ABC UNIVERSITY</strong>&nbsp;-- Sometown, OH<br />'
                + '<strong>BS, Information Technology, Concentration in Web Site Development,</strong>&nbsp;degree expected 6/2012</p>'
                + '<p><strong>Courses:</strong></p>'
                + '<ul>'
                + '<li>Web &amp; Multimedia Development</li>'
                + '<li>Digital &amp; Interactive Design</li>'
                + '<li>Graphic &amp; GUI Design</li>'
                + '<li>Search Engine Optimization (SEO)</li>'
                + '<li>3D Animation &amp; Agile Methodologies</li>'
                + '</ul>'
                + '<ul>'
                + '<li>Web Content Management</li>'
                + '<li>Internet Technologies</li>'
                + '<li>Compression Formats</li>'
                + '<li>Audio/Video Editing</li>'
                + '<li>System Security</li>'
                + '</ul>'
                + '<p><strong>Web Development Experience</strong></p>'
                + '<p><strong>ABC CHARITY,&nbsp;</strong>Sometown Chapter -- Sometown, OH<br />'
                + '<strong>Web Developer,</strong>&nbsp;Summers 2009-2011<br />'
                + '<br />'
                + 'Volunteered as a Web developer for newly opened animal shelter.</p>'
                + '<ul>'
                + '<li>Co-developed a dynamic, secure Web site from scratch. Launched visually appealing, user-friendly Webscape with interactive features to optimize traffic, page views, site &quot;stickiness&quot; and user experience (UX).</li>'
                + '<li>Used SEO best practices to elevate organization&#39;s Web presence.</li>'
                + '<li>Created online surveys, contests and donation forms that boosted funding and organizational visibility. Helped drive $38K in ecommerce revenues.</li>'
                + '<li>Engineered innovative &quot;Adopt-a-Pet&quot; Web application customized for mobile devices. Honored with &quot;Volunteer of the Year&quot; award as a result.</li>'
                + '</ul>')
        def paulDocumentITCoverLetter= new Document(documentTypeCoverLetter, paul, 'IT Cover Letter for Software Developer',    '<h3>What is Lorem Ipsum?</h3>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')
        def paulDocumentHelpDeskCoverLetter = new Document(documentTypeCoverLetter, paul, 'Help Desk Cover Letter',             '<h3>What is Lorem Ipsum?</h3>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')

        def bryanDocumentITResume = new Document(documentTypeResume, bryan, 'IT Resume For Software Developer',                 '<h3>What is Lorem Ipsum?</h3>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')
        def bryanDocumentHelpDeskResume = new Document(documentTypeResume, bryan, 'Help Desk Resume',                           '<h3>What is Lorem Ipsum?</h3>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')
        def bryanDocumentITCoverLetter= new Document(documentTypeCoverLetter, bryan, 'IT Cover Letter for Software Developer',  '<h3>What is Lorem Ipsum?</h3>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')
        def bryanDocumentHelpDeskCoverLetter = new Document(documentTypeCoverLetter, bryan, 'Help Desk Cover Letter',           '<h3>What is Lorem Ipsum?</h3>\n\n<p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>')

        baseline.addAll(paulDocumentITResume, paulDocumentHelpDeskResume, paulDocumentITCoverLetter, paulDocumentHelpDeskCoverLetter)
        baseline.addAll(bryanDocumentITResume, bryanDocumentHelpDeskResume, bryanDocumentITCoverLetter, bryanDocumentHelpDeskCoverLetter)


        Job jobSoftWareDeveloper = new Job('Software Developer', informationTechnology, 'Life Line Solutions at the University of Wisconsin Madison is seeking a Director of Informatics to establish the department as a premier and trusted source of informatics tools and resources. A software developer is a person concerned with facets of the software development process, including the research, design, programming, and testing of computer software')
        Job jobHelpDesk = new Job('Help Desk', informationTechnology,'a service providing information and support to computer users, especially within a company.')
        Job jobFinanceSpecialist = new Job('Finance Specialist', finance, 'Responsible for salary and other expenses' )
        Job jobHumanResourceDirector = new Job('Human Resource Director', humanResources, 'Human resources are the people who make up the workforce of an organization, business sector, or economy. "Human capital" is sometimes used ...')
        Job jobNurse = new Job('Nurse', healthCare, 'Nursing is a profession within the health care sector focused on the care of individuals, families, and communities so they may attain, maintain, or recover optimal health and quality of life.')
        Job jobResidentAssistant = new Job('Resident Assistant', healthCare, '')
        Job jobScientist = new Job('Scientist', healthCare, 'Life Line Solutions is seeking a Scientist to join a research lab. Scientist will work with the principal investigator on using molecular imaging to better understand the biology of breast cancer including its response to targeted drug therapies. Refer to http://www.ohr.wisc.edu/Weblisting/External/PVLSummary.aspx?pvl_num=84421 for complete position description.')
        Job jobOfficeAssistant = new Job('Office Assistant', adminstrative, 'Life Line Solutions has an opening for a student hourly office assistant. Student must be available to work during normal business hours; Monday through Friday between 8:00 a.m. and 4:30 p.m. Summary: This position will assist department leadership and staff with a wide variety of clerical and administrative duties. Preference will be given to students with excellent interpersonal skills and a well-organized approach to their daily work.')
        Job jobInformatics = new Job('Informatics Specialist', informationTechnology, 'Life Line Solutions at the University of Wisconsin Madison is seeking a Director of Informatics to establish the department as a premier and trusted source of informatics tools and resources')

        baseline.addAll(jobSoftWareDeveloper, jobHelpDesk, jobFinanceSpecialist, jobHumanResourceDirector, jobNurse, jobResidentAssistant, jobInformatics, jobScientist, jobOfficeAssistant)

        //job, employmentType, start, end, salaryRange, active (bool)
        JobPost informaticsSpecialist = new JobPost(
                job: jobInformatics,
                employmentType: fullTime,
                postStart: 'July 01, 2016',
                postEnd: 'Sept 01, 2016',
                salaryRange: '70,000 - 120,000',
                active: true
        )
        //job, employmentType, start, end, salaryRange, active (bool)
        JobPost officeAssistant = new JobPost(
                job: jobOfficeAssistant,
                employmentType: partTime,
                postStart: 'July 01, 2016',
                postEnd: 'Sept 01, 2016',
                salaryRange: '34,500 - 60,000',
                active: true
        )
        //job, employmentType, start, end, salaryRange, active (bool)
        JobPost scientist = new JobPost(
                job: jobScientist,
                employmentType: fullTime,
                postStart: 'July 01, 2016',
                postEnd: 'Sept 01, 2016',
                salaryRange: '80,000 - 110,000',
                active: true
        )

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

        baseline.addAll(softwareDev, helpDeskSupport, softwareDev,hrStaff, nurseProfessional, residentAssistant, informaticsSpecialist, officeAssistant, scientist)

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
