package ZeroShot.claude;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class Task112 {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public Task112() {
        // Initialize connection with security best practices
        String connectionString = System.getenv("MONGODB_URI"); // Get connection string from environment variable
        if(connectionString == null || connectionString.isEmpty()) {
            throw new IllegalStateException("MongoDB connection string not found in environment variables");
        }
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase("testdb");
        collection = database.getCollection("users");
    }

    public void create(String name, int age) {
        try {
            Document doc = new Document("name", name)
                    .append("age", age);
            collection.insertOne(doc);
        } catch(Exception e) {
            throw new RuntimeException("Failed to create document: " + e.getMessage());
        }
    }

    public Document read(String name) {
        try {
            return collection.find(Filters.eq("name", name)).first();
        } catch(Exception e) {
            throw new RuntimeException("Failed to read document: " + e.getMessage());
        }
    }

    public void update(String name, int newAge) {
        try {
            collection.updateOne(
                Filters.eq("name", name), 
                Updates.set("age", newAge)
            );
        } catch(Exception e) {
            throw new RuntimeException("Failed to update document: " + e.getMessage());
        }
    }

    public void delete(String name) {
        try {
            collection.deleteOne(Filters.eq("name", name));
        } catch(Exception e) {
            throw new RuntimeException("Failed to delete document: " + e.getMessage());
        }
    }

    public void closeConnection() {
        if(mongoClient != null) {
            mongoClient.close();
        }
    }

    public static void main(String[] args) {
        Task112 db = new Task112();
        
        try {
            // Test Case 1: Create
            db.create("John Doe", 25);
            System.out.println("Created document for John Doe");

            // Test Case 2: Read
            Document doc = db.read("John Doe");
            System.out.println("Read document: " + doc.toJson());

            // Test Case 3: Update
            db.update("John Doe", 26);
            System.out.println("Updated John Doe's age");

            // Test Case 4: Read after update
            doc = db.read("John Doe");
            System.out.println("After update: " + doc.toJson());

            // Test Case 5: Delete
            db.delete("John Doe");
            System.out.println("Deleted John Doe's document");

        } catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.closeConnection();
        }
    }
}
