package ZeroShot.llama31;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class Task112 {
    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("employees");

        // Create
        Document doc = new Document("name", "John Doe")
                .append("age", 30)
                .append("position", "Software Engineer");
        collection.insertOne(doc);

        // Read
        Document readDoc = collection.find(Filters.eq("name", "John Doe")).first();
        System.out.println("Read Document: " + readDoc);

        // Update
        collection.updateOne(Filters.eq("name", "John Doe"), new Document("$set", new Document("age", 31)));
        readDoc = collection.find(Filters.eq("name", "John Doe")).first();
        System.out.println("Updated Document: " + readDoc);

        // Delete
        collection.deleteOne(Filters.eq("name", "John Doe"));
        System.out.println("Document deleted successfully.");
    }
}