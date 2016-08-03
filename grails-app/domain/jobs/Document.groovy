package jobs

class Document {
    DocumentType type
    String filePath



    static constraints = {
        filePath nullable:true
    }

    static belongsTo = [user: User]
    static hasOne = DocumentType

    String toString() {"$type"}
}
