package Vanilla.llama31;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class Task112 {
    private static final String URI = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "mydb";
    private static final String COLLECTION_NAME = "students";

    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create(URI);
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        // Create
        Document studentDoc = new Document("regNo", "3014")
                .append("name", "Test Student")
                .append("course", new Document("courseName", "MCA").append("duration", "3 Years"))
                .append("address", new Document("city", "Bangalore").append("state", "KA"));
        collection.insertOne(studentDoc);

        // Read
        Document readDoc = collection.find(Filters.eq("regNo", "3014")).first();
        System.out.println("Read Document: " + readDoc);

        // Update
        collection.updateOne(Filters.eq("regNo", "3014"), new Document("$set", new Document("name", "Updated Student")));
        readDoc = collection.find(Filters.eq("regNo", "3014")).first();
        System.out.println("Updated Document: " + readDoc);

        // Delete
        collection.deleteOne(Filters.eq("regNo", "3014"));
        System.out.println("Document deleted successfully.");

        mongoClient.close();
    }
}