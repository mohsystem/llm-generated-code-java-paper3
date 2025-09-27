package CoT.gemini;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Task112 {

    public static void main(String[] args) {
        // Replace with your MongoDB connection string
        String connectionString = "mongodb://localhost:27017"; 
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("myDatabase");
            MongoCollection<Document> collection = database.getCollection("myCollection");

            // Create
            Document document = new Document("name", "John Doe")
                    .append("age", 30)
                    .append("city", "New York");
            collection.insertOne(document);
            ObjectId insertedId = document.getObjectId("_id");
            System.out.println("Inserted document ID: " + insertedId);


            // Read
            Document foundDocument = collection.find(Filters.eq("_id", insertedId)).first();
            System.out.println("Found document: " + foundDocument.toJson());

            // Update
            collection.updateOne(Filters.eq("_id", insertedId), Updates.set("age", 35));
            Document updatedDocument = collection.find(Filters.eq("_id", insertedId)).first();
            System.out.println("Updated document: " + updatedDocument.toJson());

            // Delete
            collection.deleteOne(Filters.eq("_id", insertedId));
            System.out.println("Document deleted.");



             // Test cases
            performCRUD(collection,"Jane Doe", 25, "London");
            performCRUD(collection,"Peter Pan", 20, "Neverland");
            performCRUD(collection,"Alice Wonderland", 16, "Wonderland");
            performCRUD(collection,"Bob The Builder", 40, "Fixham");
            performCRUD(collection,"Wendy Darling", 14, "London");

        }
    }



    public static void performCRUD(MongoCollection<Document> collection, String name, int age, String city) {
        // Create
        Document document = new Document("name", name)
                .append("age", age)
                .append("city", city);
        collection.insertOne(document);
        ObjectId insertedId = document.getObjectId("_id");
        System.out.println("Inserted document ID: " + insertedId);


        // Read
        Document foundDocument = collection.find(Filters.eq("_id", insertedId)).first();
        System.out.println("Found document: " + foundDocument.toJson());

        // Update
        collection.updateOne(Filters.eq("_id", insertedId), Updates.set("age", age + 5));
        Document updatedDocument = collection.find(Filters.eq("_id", insertedId)).first();
        System.out.println("Updated document: " + updatedDocument.toJson());

        // Delete
        collection.deleteOne(Filters.eq("_id", insertedId));
        System.out.println("Document deleted.");
    }
}