package jobs

import org.joda.time.DateTime

import java.time.LocalDate

class Application {

    ApplicationDocument applicationDocument
    User user
    JobPost jobPost

    Status status
    LocalDate backgroundCheck
    LocalDate referenceCheck

    // Automatic timestamping
    DateTime dateCreated
    DateTime lastUpdated

    static mapping = {
        //status defaultValue: 'New'
    }

    static constraints = {
        backgroundCheck nullable: true
        referenceCheck nullable: true
        applicationDocument nullable: true
        jobPost nullable: true
        status nullable: false
    }

    static belongsTo = [jobPost:JobPost, user:User]
    static hasMany = ApplicationDocument
    static hasOne = Status
}
