package jobs

class EmploymentType {

    String type

    static hasMany = Job

    EmploymentType(String type) {
        this()
        this.type = type
    }

    static constraints = {
        type nullable: false
    }

    String toString() {"$type"}

}
