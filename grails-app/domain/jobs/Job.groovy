package jobs

import org.joda.time.DateTime

class Job {
    Job replacedBy

    String title
    Category category

    //auto timestamp
    DateTime dateCreated
    DateTime lastUpdated

    Job(String title, Category category) {
        this()
        this.title = title
        this.category = category
    }

    static constraints = {
        replacedBy nullable: true
    }


    static hasMany = [jobPosts: JobPost]
    static hasOne = Category
    String toString() {"$title"}
}
