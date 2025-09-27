package CoT.claude;

import com.mongodb.client.*;
import com.mongodb.client.result.*;
import org.bson.Document;
import com.mongodb.MongoException;
import java.util.Arrays;

public class Task112 {
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public Task112() {
        // Use connection string with authentication
        String connectionString = "mongodb://username:password@localhost:27017";
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase("testdb");
        collection = database.getCollection("users");
    }

    public void create(String name, int age) {
        try {
            Document doc = new Document("name", name)
                    .append("age", age);
            collection.insertOne(doc);
        } catch (MongoException e) {
            System.err.println("Error creating document: " + e.getMessage());
        }
    }

    public Document read(String name) {
        try {
            return collection.find(new Document("name", name)).first();
        } catch (MongoException e) {
            System.err.println("Error reading document: " + e.getMessage());
            return null;
        }
    }

    public void update(String name, int newAge) {
        try {
            Document query = new Document("name", name);
            Document update = new Document("$set", new Document("age", newAge));
            collection.updateOne(query, update);
        } catch (MongoException e) {
            System.err.println("Error updating document: " + e.getMessage());
        }
    }

    public void delete(String name) {
        try {
            Document query = new Document("name", name);
            collection.deleteOne(query);
        } catch (MongoException e) {
            System.err.println("Error deleting document: " + e.getMessage());
        }
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    public static void main(String[] args) {
        Task112 db = new Task112();

        // Test Case 1: Create
        db.create("John", 25);
        System.out.println("Created John's record");

        // Test Case 2: Read
        Document doc = db.read("John");
        System.out.println("Read record: " + doc);

        // Test Case 3: Update
        db.update("John", 26);
        System.out.println("Updated John's age");

        // Test Case 4: Read after update
        doc = db.read("John");
        System.out.println("Read updated record: " + doc);

        // Test Case 5: Delete
        db.delete("John");
        System.out.println("Deleted John's record");

        db.close();
    }
}
