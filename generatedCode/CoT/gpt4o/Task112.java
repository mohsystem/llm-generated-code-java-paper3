package CoT.openai;
import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClient;
import com.mongodb.MongoClients;
import java.util.Collections;

public class Task112 {
    private MongoDatabase database;

    public Task112(String user, String databaseName, char[] password) {
        MongoCredential credential = MongoCredential.createCredential(user, databaseName, password);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(Collections.singletonList(new ServerAddress("localhost", 27017))))
                .credential(credential)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        this.database = mongoClient.getDatabase(databaseName);
    }

    public void createDocument(String collectionName, Document document) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(document);
    }

    public Document readDocument(String collectionName, Document query) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.find(query).first();
    }

    public void updateDocument(String collectionName, Document query, Document update) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.updateOne(query, new Document("$set", update));
    }

    public void deleteDocument(String collectionName, Document query) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.deleteOne(query);
    }

    public static void main(String[] args) {
        Task112 task = new Task112("username", "databaseName", "password".toCharArray());

        Document doc = new Document("name", "John").append("age", 30);
        task.createDocument("users", doc);

        Document query = new Document("name", "John");
        System.out.println(task.readDocument("users", query));

        Document update = new Document("age", 31);
        task.updateDocument("users", query, update);
        System.out.println(task.readDocument("users", query));

        task.deleteDocument("users", query);
        System.out.println(task.readDocument("users", query));
    }
}