package ourMethod.llama31;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class Task112 {
    public static void main(String[] args) {
        // Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("employees");

        // Create
        Document doc = new Document("name", "John Doe")
                .append("age", 30)
                .append("position", "Software Engineer");
        collection.insertOne(doc);
        System.out.println("Document inserted successfully.");

        // Read
        Document foundDoc = collection.find(Filters.eq("name", "John Doe")).first();
        if (foundDoc != null) {
            System.out.println("Found document: " + foundDoc.toJson());
        } else {
            System.out.println("No document found with the specified criteria.");
        }

        // Update
        collection.updateOne(Filters.eq("name", "John Doe"), new Document("$set", new Document("age", 31)));
        System.out.println("Document updated successfully.");

        // Delete
        collection.deleteOne(Filters.eq("name", "John Doe"));
        System.out.println("Document deleted successfully.");

        mongoClient.close();
    }
}