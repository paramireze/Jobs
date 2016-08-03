package jobs


class Status {

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
