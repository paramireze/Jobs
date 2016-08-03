package jobs

class ApplicationDocument {
    Document document
    Application application




    static belongsTo = [docu: Application]

    String toString() {"$type"}

}
