package jobs

class DocumentType {

    String type

    static hasMany = Document

    DocumentType(String type) {
        this()
        this.type = type
    }

    String toString() {"$type"}
}
