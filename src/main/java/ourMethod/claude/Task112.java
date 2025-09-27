package ourMethod.claude;

import com.mongodb.client.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.bson.Document;

public class Task112 {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    
    public Task112() {
        // Use connection string with authentication
        String connectionString = "mongodb://username:password@localhost:27017";
        mongoClient = new MongoClient(new MongoClientURI(connectionString));
        database = mongoClient.getDatabase("testdb");
        collection = database.getCollection("users");
    }

    // Create operation
    public void createDocument(String name, int age) {
        try {
            Document doc = new Document("name", name)
                          .append("age", age);
            collection.insertOne(doc);
        } catch(Exception e) {
            System.err.println("Error creating document: " + e.getMessage());
        }
    }

    // Read operation 
    public Document readDocument(String name) {
        try {
            Document query = new Document("name", name);
            return collection.find(query).first();
        } catch(Exception e) {
            System.err.println("Error reading document: " + e.getMessage());
            return null;
        }
    }

    // Update operation
    public void updateDocument(String name, int newAge) {
        try {
            Document query = new Document("name", name);
            Document update = new Document("$set", new Document("age", newAge));
            collection.updateOne(query, update);
        } catch(Exception e) {
            System.err.println("Error updating document: " + e.getMessage());
        }
    }

    // Delete operation
    public void deleteDocument(String name) {
        try {
            Document query = new Document("name", name);
            collection.deleteOne(query);
        } catch(Exception e) {
            System.err.println("Error deleting document: " + e.getMessage());
        }
    }

    // Close connection
    public void close() {
        if(mongoClient != null) {
            mongoClient.close();
        }
    }

    public static void main(String[] args) {
        Task112 db = new Task112();
        
        // Test case 1: Create
        db.createDocument("John", 25);
        
        // Test case 2: Read
        Document doc = db.readDocument("John");
        System.out.println("Read: " + doc);
        
        // Test case 3: Update
        db.updateDocument("John", 26);
        doc = db.readDocument("John");
        System.out.println("After update: " + doc);
        
        // Test case 4: Delete
        db.deleteDocument("John");
        doc = db.readDocument("John");
        System.out.println("After delete: " + doc);
        
        // Test case 5: Create multiple
        db.createDocument("Alice", 30);
        db.createDocument("Bob", 35);
        
        db.close();
    }
}
