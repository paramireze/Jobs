package jobs

class Category {
    String type
    String description

    Category(String type, String description) {
        this()
        this.type = type
        this.description = description
    }

    static constraints = {
        description nullable: true
    }

    static hasMany = Job

    String toString() {"$type"}

}
