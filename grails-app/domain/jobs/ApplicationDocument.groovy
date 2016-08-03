package jobs

class ApplicationDocument {
    Document document
    Application application




    static belongsTo = [application: Application, document: Document]

    String toString() {"$type"}

}
