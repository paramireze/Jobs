package jobs


class Status {

    String name


    Status(String name) {
        this()
        this.name = name
    }

    static constraints = {
        name nullable: false
    }

    String toString() {"$name"}

}
