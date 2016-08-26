package jobs

class Application {

    User user
    JobPost jobPost
    Status status
    Document resume
    Document coverLetter
    String freeText

    static constraints = {
        jobPost nullable: false
        status nullable: false
        resume nullable: true
        coverLetter nullable: true
        freeText nullable: true
    }

    Application(User user, JobPost jobPost, Document resume, Document coverLetter, Status status, freeText) {
        this()
        this.user = user
        this.jobPost = jobPost
        this.resume = resume
        this.coverLetter = coverLetter
        this.status = status
        this.freeText = freeText
    }

    static belongsTo = [user:User]
    static hasOne = Status

    String toString() {"Job Application for $jobPost"}

}
