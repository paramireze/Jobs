package jobs

class UserDocument {
    User user


    String type
    String filePath

    UserDocument(String type, String filePath) {
        this()
        this.type = type
        this.filePath = filePath
    }

    static constraints = {
        filePath nullable:true
    }

    static belongsTo = [users: User]

    String toString() {"$type"}

}
