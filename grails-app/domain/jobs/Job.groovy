package jobs

class Job {
    Job replacedBy

    String title
    Category category
    String description

    Job(String title, Category category, String description) {
        this()
        this.title = title
        this.category = category
        this.description = description
    }

    static constraints = {
        replacedBy nullable: true
        description maxValue: 2000
        description nullable: true
    }


    static hasMany = [jobPosts: JobPost]
    static hasOne = Category
    String toString() {"$title"}
}
