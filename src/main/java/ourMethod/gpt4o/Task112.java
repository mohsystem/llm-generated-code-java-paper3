package ourMethod.gpt4o;
// MongoDB interaction requires MongoDB driver and a running MongoDB instance. 
// Due to security constraints, we cannot directly implement MongoDB interaction here. 
// Below is a template code for MongoDB CRUD operations in Java:

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

public class Task112 {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public Task112(String uri, String dbName, String collectionName) {
        mongoClient = MongoClients.create(uri);
        database = mongoClient.getDatabase(dbName);
        collection = database.getCollection(collectionName);
    }

    public void createDocument(Document document) {
        collection.insertOne(document);
    }

    public Document readDocument(String key, Object value) {
        return collection.find(eq(key, value)).first();
    }

    public void updateDocument(String key, Object value, Document updatedDocument) {
        collection.updateOne(eq(key, value), new Document("$set", updatedDocument));
    }

    public void deleteDocument(String key, Object value) {
        collection.deleteOne(eq(key, value));
    }

    public void close() {
        mongoClient.close();
    }

    public static void main(String[] args) {
        // Please replace with your MongoDB connection details
        Task112 mongoDBTask = new Task112("mongodb://localhost:27017", "myDatabase", "myCollection");

        Document doc1 = new Document("name", "John Doe").append("age", 29);
        Document doc2 = new Document("name", "Jane Doe").append("age", 25);
        Document doc3 = new Document("name", "Alice").append("age", 32);
        Document doc4 = new Document("name", "Bob").append("age", 45);
        Document doc5 = new Document("name", "Charlie").append("age", 35);

        // Create
        mongoDBTask.createDocument(doc1);
        mongoDBTask.createDocument(doc2);
        mongoDBTask.createDocument(doc3);
        mongoDBTask.createDocument(doc4);
        mongoDBTask.createDocument(doc5);

        // Read
        System.out.println("Read: " + mongoDBTask.readDocument("name", "John Doe"));

        // Update
        mongoDBTask.updateDocument("name", "John Doe", new Document("age", 30));

        // Delete
        mongoDBTask.deleteDocument("name", "Jane Doe");

        // Close connection
        mongoDBTask.close();
    }
}