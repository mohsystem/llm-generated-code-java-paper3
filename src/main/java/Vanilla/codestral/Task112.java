package Vanilla.codestral;
// Java
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class Task112 {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("testCollection");

        // Create
        Document document = new Document("name", "John Doe").append("age", 30);
        collection.insertOne(document);

        // Read
        Document readDocument = collection.find(new Document("name", "John Doe")).first();
        System.out.println(readDocument.toJson());

        // Update
        collection.updateOne(new Document("name", "John Doe"), new Document("$set", new Document("age", 31)));

        // Delete
        collection.deleteOne(new Document("name", "John Doe"));

        mongoClient.close();
    }
}