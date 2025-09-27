package ZeroShot.codestral;
// Java code
// Note: This requires the MongoDB Java Driver
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Task112 {
    private static MongoCollection<Document> collection;

    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");
        collection = database.getCollection("testCollection");

        // Test cases
        createDocument("testId1", "testData1");
        readDocument("testId1");
        updateDocument("testId1", "updatedData1");
        readDocument("testId1");
        deleteDocument("testId1");
    }

    public static void createDocument(String id, String data) {
        Document document = new Document("_id", id).append("data", data);
        collection.insertOne(document);
    }

    public static Document readDocument(String id) {
        Document document = collection.find(new Document("_id", id)).first();
        if (document != null) {
            System.out.println(document.toJson());
        } else {
            System.out.println("Document not found.");
        }
        return document;
    }

    public static void updateDocument(String id, String data) {
        collection.updateOne(new Document("_id", id), new Document("$set", new Document("data", data)));
    }

    public static void deleteDocument(String id) {
        collection.deleteOne(new Document("_id", id));
    }
}