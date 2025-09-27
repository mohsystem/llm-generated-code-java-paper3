package ourMethod.gemini;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

public class Task112 {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017"; // Update with your connection string
    private static final String DATABASE_NAME = "mydatabase"; // Update with your database name
    private static final String COLLECTION_NAME = "mycollection"; // Update with your collection name


    public static void create(MongoClient mongoClient, Document document) {
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        collection.insertOne(document);
    }


    public static FindIterable<Document> read(MongoClient mongoClient, Bson filter) {
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        if (filter == null) {
            return collection.find();
        } else {
            return collection.find(filter);
        }
    }


    public static void update(MongoClient mongoClient, Bson filter, Bson update) {
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        collection.updateOne(filter, update);
    }


    public static void delete(MongoClient mongoClient, Bson filter) {
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        collection.deleteOne(filter);
    }


    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {

            // Test cases
            Document document1 = new Document("name", "Alice").append("age", 30);
            create(mongoClient, document1);

            Bson filter = Filters.eq("name", "Alice");
            FindIterable<Document> result = read(mongoClient, filter);
            for (Document doc : result) {
                System.out.println(doc.toJson());
            }

            Bson update = Updates.set("age", 35);
            update(mongoClient, filter, update);

            result = read(mongoClient, filter);
            for (Document doc : result) {
                System.out.println(doc.toJson());
            }

            delete(mongoClient, filter);


            Document document2 = new Document("name", "Bob").append("age", 25);
            create(mongoClient, document2);
            filter = Filters.eq("name", "Bob");
            delete(mongoClient, filter);

             Document document3 = new Document("name", "Charlie").append("age", 40);
            create(mongoClient, document3);
             filter = Filters.eq("name", "Charlie");
             update(mongoClient, filter, Updates.set("city","New York"));


             Document document4 = new Document("name", "David").append("age", 28);
            create(mongoClient, document4);
            filter = Filters.eq("name", "David");
            result = read(mongoClient, filter);
            for (Document doc : result) {
                System.out.println(doc.toJson());
            }

             Document document5 = new Document("name", "Eve").append("age", 32);
            create(mongoClient, document5);
            filter = Filters.eq("name", "Eve");
             Bson update5 = Updates.combine(Updates.set("city","London"), Updates.set("occupation","Engineer"));
            update(mongoClient, filter, update5);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}