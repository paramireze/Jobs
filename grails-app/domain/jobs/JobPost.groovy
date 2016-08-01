package jobs

import org.joda.time.DateTime

class JobPost {

    Job job
    Application application

    DateTime start
    DateTime end
    String salaryRange
    Boolean active
    JobPost previousJobPost

    static mapping = {
        active defaultValue: true
    }

    static constraints = {
        salaryRange nullable: true
        previousJobPost nullable: true

        // start(validator: { val, obj -> val < end })  // make sure start date is not after end date
    }

    static belongsTo = Job
    static hasMany = Application

    String toString() {"$job"}
}
