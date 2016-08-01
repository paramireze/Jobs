package jobs

import org.joda.time.DateTime

class Job {
    Job replacedBy

    String title
    Category category
    String position
    String description
    DateTime dateCreated
    DateTime lastUpdated

    Job(String title, Category category, String position) {
        this()
        this.title = title
        this.category = category
        this.position = position
    }

    static UserRole get(long userId, long roleId) {
        find 'from UserRole where user.id=:personId and role.id=:roleId'
        [userId: userId, roleId: roleId]
    }

    static constraints = {
        description nullable: true
        replacedBy nullable: true
    }


    static hasMany = [jobPost: JobPost]
    static hasOne = Category
    String toString() {"$position"}
}
