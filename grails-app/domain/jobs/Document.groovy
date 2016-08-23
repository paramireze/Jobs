package jobs

class Document {
    DocumentType type
    User user
    String title
    String body
    String filePath



    static constraints = {
        body nullable:true
        filePath nullable:true
        body maxSize: 20000
    }

    Document(DocumentType type,User user, String title, String body) {
        this()
        this.type = type
        this.user = user
        this.title = title
        this.body = body
    }


    static belongsTo = [user: User]
    static hasOne = DocumentType

    String toString() {"$title"}
}
