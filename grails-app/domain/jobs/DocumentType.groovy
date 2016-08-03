package jobs

class DocumentType {

    String type

    static hasMany = Document
    String toString() {"$type"}

}
