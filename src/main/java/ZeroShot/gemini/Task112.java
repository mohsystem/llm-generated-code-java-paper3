package ZeroShot.gemini;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Task112 {

    private static final String uri = "mongodb://localhost:27017"; // Replace with your MongoDB connection string
    private static final String databaseName = "mydatabase"; // Replace with your database name
    private static final String collectionName = "mycollection"; // Replace with your collection name


    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);


            // Create
            Document document = new Document("_id", new ObjectId()).append("name", "John Doe").append("age", 30);
            collection.insertOne(document);
            System.out.println("Document inserted successfully.");

            // Read
            FindIterable<Document> iterable = collection.find(Filters.eq("name", "John Doe"));
            for (Document doc : iterable) {
                System.out.println(doc.toJson());
            }


            // Update
             collection.updateOne(Filters.eq("name", "John Doe"), Updates.set("age", 35));
            System.out.println("Document updated successfully.");



            // Delete
            collection.deleteOne(Filters.eq("name", "John Doe"));
            System.out.println("Document deleted successfully.");




        }
    }


}