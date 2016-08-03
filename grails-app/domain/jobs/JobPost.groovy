package jobs

import org.joda.time.DateTime

class JobPost {

    Job job
    Application application
    EmploymentType employmentType

    DateTime start
    DateTime end
    String salaryRange
    Boolean active
    JobPost previousJobPost

    static mapping = {
        active defaultValue: true
    }

    static hasOne = EmploymentType

    static constraints = {
        salaryRange nullable: true
        previousJobPost nullable: true

        // start(validator: { val, obj -> val < end })  // make sure start date is not after end date
    }

    static belongsTo = [
            job:Job,

            ]
    static hasMany = Application

    String toString() {"$job"}
}
