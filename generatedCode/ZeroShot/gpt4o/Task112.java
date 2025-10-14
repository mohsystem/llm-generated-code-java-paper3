package ZeroShot.openai;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.FindIterable;
import java.util.Arrays;

public class Task112 {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public Task112(String host, int port, String dbName, String collectionName) {
        mongoClient = new MongoClient(host, port);
        database = mongoClient.getDatabase(dbName);
        collection = database.getCollection(collectionName);
    }

    public void createDocument(String key, Object value) {
        Document doc = new Document(key, value);
        collection.insertOne(doc);
    }

    public Document readDocument(String key, Object value) {
        return collection.find(Filters.eq(key, value)).first();
    }

    public UpdateResult updateDocument(String key, Object oldValue, Object newValue) {
        return collection.updateOne(Filters.eq(key, oldValue), set(key, newValue));
    }

    public DeleteResult deleteDocument(String key, Object value) {
        return collection.deleteOne(Filters.eq(key, value));
    }

    public void close() {
        mongoClient.close();
    }

    public static void main(String[] args) {
        Task112 task = new Task112("localhost", 27017, "testDB", "testCollection");

        // Test case 1: Create a document
        task.createDocument("name", "John");

        // Test case 2: Read the document
        Document doc = task.readDocument("name", "John");
        System.out.println("Read Document: " + doc.toJson());

        // Test case 3: Update the document
        UpdateResult updateResult = task.updateDocument("name", "John", "Doe");
        System.out.println("Update Count: " + updateResult.getModifiedCount());

        // Test case 4: Read the updated document
        Document updatedDoc = task.readDocument("name", "Doe");
        System.out.println("Updated Document: " + updatedDoc.toJson());

        // Test case 5: Delete the document
        DeleteResult deleteResult = task.deleteDocument("name", "Doe");
        System.out.println("Delete Count: " + deleteResult.getDeletedCount());

        task.close();
    }
}