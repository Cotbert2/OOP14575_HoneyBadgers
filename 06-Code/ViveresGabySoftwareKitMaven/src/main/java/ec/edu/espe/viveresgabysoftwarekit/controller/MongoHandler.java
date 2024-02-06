package ec.edu.espe.viveresgabysoftwarekit.controller;

/**
 *
 * @author mateo
 */
import com.google.gson.Gson;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import ec.edu.espe.viveresgabysoftwarekit.model.*;
import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;

public class MongoHandler {
     
    private static final String DataBase = "viveres_gaby_software_kit_DB";

    public static MongoClient mongoClient;

    public static MongoClient conectToDb() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(Constans.URI);
        }
        return mongoClient;
    }

    public static List<Customer> listCustomers() {
        conectToDb();
        MongoDatabase database = mongoClient.getDatabase(DataBase);
        MongoCollection<Document> collection = database.getCollection("Customers");

        List<Document> fullTable = collection.find().into(new ArrayList<>());
        List<Customer> customersFromDataBase = new ArrayList<>();

        for (Document doc : fullTable) {
            customersFromDataBase.add(new Gson().fromJson(doc.toJson(), Customer.class));
        }
        return customersFromDataBase;

    }

    public static List<Product> listProducts() {
        conectToDb();
        MongoDatabase database = mongoClient.getDatabase(DataBase);
        MongoCollection<Document> collection = database.getCollection("Product");

        List<Document> fullTable = collection.find().into(new ArrayList<>());
        List<Product> customersFromDataBase = new ArrayList<>();

        for (Document doc : fullTable) {
            customersFromDataBase.add(new Gson().fromJson(doc.toJson(), Product.class));
        }
        return customersFromDataBase;

    }

    public static void insertProduct(Product product) {
        conectToDb();
        MongoDatabase database = mongoClient.getDatabase(DataBase);
        MongoCollection<Document> collection = database.getCollection("Product");
        Gson gson = new Gson();
        collection.insertOne(Document.parse(gson.toJson(product)));

    }

    public static void editProduct(Product product) {
        conectToDb();
        MongoDatabase database = mongoClient.getDatabase(DataBase);
        MongoCollection<Document> collection = database.getCollection("Product");
        Document filter = new Document("id", product.getId());
        Document updateItem = new Document("$set", new Document()
        .append("name", product.getName())
        .append("cost", product.getCost())
        .append("pvp",product.getPvp())
        .append("description", product.getDescription())
        .append("provider", product.getProvider()));
        
        collection.updateOne(filter, updateItem);
    }
    
    public static void deleteProduct(int id ){
        conectToDb();
        MongoDatabase database = mongoClient.getDatabase(DataBase);
        MongoCollection<Document> collection = database.getCollection("Product");
        Document filter = new Document("id", id);
        collection.deleteOne(filter);
    }
}
