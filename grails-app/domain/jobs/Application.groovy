package jobs

class Application {

    User user
    JobPost jobPost
    Status status

    static constraints = {
        jobPost nullable: false
        status nullable: false
    }

    Application(User user, JobPost jobPost, Status status = new Status('new') ) {
        this()
        this.user = user
        this.jobPost = jobPost
        this.status = status
    }

    static belongsTo = [user:User]
    static hasMany = ApplicationDocument
    static hasOne = Status

    String toString() {"Job Application for $jobPost"}

}
