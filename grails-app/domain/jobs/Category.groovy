package jobs

import org.joda.time.DateTime

class Category {
    String type
    String description

    //auto timestamp
    DateTime dateCreated
    DateTime lastUpdated

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
