package jobs

class Application {

    ApplicationDocument applicationDocument
    User user
    JobPost jobPost
    Status status

    static constraints = {
        applicationDocument nullable: true
        jobPost nullable: true
        status nullable: false
    }

    static belongsTo = [jobPost:JobPost, user:User]
    static hasMany = ApplicationDocument
    static hasOne = Status
}
