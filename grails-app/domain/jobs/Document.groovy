package jobs

import org.joda.time.DateTime

class Document {
    DocumentType type
    String filePath

    // Automatic timestamping
    DateTime dateCreated
    DateTime lastUpdated


    static constraints = {
        filePath nullable:true
    }

    static belongsTo = [user: User]
    static hasOne = DocumentType

    String toString() {"$type"}
}
