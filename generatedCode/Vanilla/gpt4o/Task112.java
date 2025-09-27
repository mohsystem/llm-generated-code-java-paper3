package Vanilla.gpt4o;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

public class Task112 {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public Task112(String dbName, String collectionName) {
        mongoClient = new MongoClient("localhost", 27017);
        database = mongoClient.getDatabase(dbName);
        collection = database.getCollection(collectionName);
    }

    public void createDocument(Document doc) {
        collection.insertOne(doc);
    }

    public List<Document> readDocuments() {
        return collection.find().into(new ArrayList<>());
    }

    public UpdateResult updateDocument(String id, Document updatedDoc) {
        return collection.updateOne(Filters.eq("_id", id), new Document("$set", updatedDoc));
    }

    public DeleteResult deleteDocument(String id) {
        return collection.deleteOne(Filters.eq("_id", id));
    }

    public static void main(String[] args) {
        Task112 task = new Task112("testDB", "testCollection");

        // Test case 1: Create
        Document doc1 = new Document("_id", "1").append("name", "Alice").append("age", 30);
        task.createDocument(doc1);

        // Test case 2: Read
        List<Document> documents = task.readDocuments();
        System.out.println("Documents: " + documents);

        // Test case 3: Update
        Document updatedDoc = new Document("age", 31);
        task.updateDocument("1", updatedDoc);

        // Test case 4: Read after Update
        documents = task.readDocuments();
        System.out.println("Documents after update: " + documents);

        // Test case 5: Delete
        task.deleteDocument("1");
        documents = task.readDocuments();
        System.out.println("Documents after deletion: " + documents);

        task.mongoClient.close();
    }
}