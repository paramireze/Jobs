package jobs

import org.joda.time.DateTime

class DocumentType {

    String type

    // Automatic timestamping
    DateTime dateCreated
    DateTime lastUpdated

    static hasMany = Document
    String toString() {"$type"}

}
