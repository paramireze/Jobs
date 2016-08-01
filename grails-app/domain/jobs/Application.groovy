package jobs

import java.time.LocalDate

class Application {

    UserDocument userDocument
    User user
    JobPost jobPost

    String status
    LocalDate backgroundCheck
    LocalDate referenceCheck

    static mapping = {
        status defaultValue: 'New'
    }
    
    static constraints = {
        backgroundCheck nullable: true
        referenceCheck nullable: true
    }

    static belongsTo = JobPost
    static hasMany = UserDocument
}
