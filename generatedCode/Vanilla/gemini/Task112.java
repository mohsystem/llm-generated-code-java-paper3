package Vanilla.gemini;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;

public class Task112 {

    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017"; // Replace with your MongoDB connection string
        try (MongoClient mongoClient = MongoClients.create(uri)) {

            MongoDatabase database = mongoClient.getDatabase("myDatabase"); // Replace with your database name
            MongoCollection<Document> collection = database.getCollection("myCollection"); // Replace with your collection name


            // Create
            Document document = new Document("_id", new ObjectId()).append("name", "John Doe").append("age", 30);
            collection.insertOne(document);
            System.out.println("Document inserted successfully.");

            // Read
            Document foundDocument = collection.find(new Document("name", "John Doe")).first();
            System.out.println("Found document: " + foundDocument.toJson());


            // Update
            collection.updateOne(new Document("name", "John Doe"), new Document("$set", new Document("age", 35)));
            System.out.println("Document updated successfully.");

            // Delete
            collection.deleteOne(new Document("name", "John Doe"));
            System.out.println("Document deleted successfully.");



             // Test cases
            performCRUD("Test1", 20);
            performCRUD("Test2", 25);
            performCRUD("Test3", 30);
            performCRUD("Test4", 35);
            performCRUD("Test5", 40);



        }
    }


    public static void performCRUD(String name, int age) {

        String uri = "mongodb://localhost:27017"; // Replace with your MongoDB connection string
        try (MongoClient mongoClient = MongoClients.create(uri)) {

            MongoDatabase database = mongoClient.getDatabase("myDatabase"); // Replace with your database name
            MongoCollection<Document> collection = database.getCollection("myCollection"); // Replace with your collection name

           Document document = new Document("_id", new ObjectId()).append("name", name).append("age", age);
            collection.insertOne(document);


           Document foundDocument = collection.find(new Document("name", name)).first();


            collection.updateOne(new Document("name", name), new Document("$set", new Document("age", age+5)));


            collection.deleteOne(new Document("name", name));

        }

    }
}