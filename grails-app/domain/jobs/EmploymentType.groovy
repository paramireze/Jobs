package jobs

import org.joda.time.DateTime

class EmploymentType {

    String type

    //auto timestamp
    DateTime dateCreated
    DateTime lastUpdated

    static hasMany = Job

    static constraints = {
        type nullable: false
    }

    String toString() {"$type"}

}
