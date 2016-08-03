package jobs

class Category {
    String type
    String description


    static constraints = {
        description nullable: true
    }

    Category(String type, String description) {
        this()
        this.type = type
        this.description = description
    }

    static hasMany = Job

    String toString() {"$type"}

}
