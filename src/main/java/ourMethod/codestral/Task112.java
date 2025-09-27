package ourMethod.codestral;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class Task112 {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test");

        // Create
        Document doc = new Document("name", "MongoDB").append("type", "database");
        collection.insertOne(doc);

        // Read
        Document myDoc = collection.find(Filters.eq("name", "MongoDB")).first();
        System.out.println(myDoc.toJson());

        // Update
        collection.updateOne(Filters.eq("name", "MongoDB"), new Document("$set", new Document("type", "NoSQL database")));

        // Delete
        collection.deleteOne(Filters.eq("name", "MongoDB"));

        mongoClient.close();
    }
}