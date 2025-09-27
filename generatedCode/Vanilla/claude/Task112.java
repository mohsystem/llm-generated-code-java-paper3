package Vanilla.claude;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class Task112 {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public Task112() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("testdb");
        collection = database.getCollection("users");
    }

    public void create(String name, int age) {
        Document document = new Document("name", name)
                .append("age", age);
        collection.insertOne(document);
    }

    public Document read(String name) {
        return collection.find(Filters.eq("name", name)).first();
    }

    public void update(String name, int newAge) {
        collection.updateOne(
            Filters.eq("name", name),
            Updates.set("age", newAge)
        );
    }

    public void delete(String name) {
        collection.deleteOne(Filters.eq("name", name));
    }

    public static void main(String[] args) {
        Task112 mongo = new Task112();

        // Test Case 1: Create
        mongo.create("John", 25);

        // Test Case 2: Read
        System.out.println(mongo.read("John"));

        // Test Case 3: Update
        mongo.update("John", 26);
        System.out.println(mongo.read("John"));

        // Test Case 4: Create another record
        mongo.create("Jane", 30);

        // Test Case 5: Delete
        mongo.delete("John");
    }
}
