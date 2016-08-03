package jobs

import org.joda.time.DateTime

class Status {

    // Automatic timestamping
    DateTime dateCreated
    DateTime lastUpdated

    String name


    static hasMany = Application

    Status(String name) {
        this()
        this.name = name
    }

    static constraints = {
        name nullable: false
    }
}
