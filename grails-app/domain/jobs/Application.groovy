package jobs

import org.joda.time.DateTime
import org.joda.time.LocalDate

class Application {

    User user
    JobPost jobPost
    Status status
    Document resume
    Document coverLetter
    String freeText

    // Automatic timestamping
    LocalDate dateCreated


    static constraints = {
        jobPost nullable: false
        status nullable: false
        resume nullable: true
        coverLetter nullable: true
        freeText nullable: true
        freeText maxValue: 20000

    }

    Application(User user, JobPost jobPost, Document resume, Document coverLetter, Status status, freeText) {
        this()
        this.user = user
        this.jobPost = jobPost
        this.resume = resume
        this.coverLetter = coverLetter
        this.status = status
        this.freeText = freeText
        this.dateCreated = LocalDate.now()
    }

    static belongsTo = [user:User]
    static hasOne = Status

    String toString() {"Job Application for $jobPost"}

}
