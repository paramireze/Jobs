package jobs

class EmploymentType {

    String type

    static hasMany = Job

    static constraints = {
        type nullable: false
    }

    String toString() {"$type"}

}
