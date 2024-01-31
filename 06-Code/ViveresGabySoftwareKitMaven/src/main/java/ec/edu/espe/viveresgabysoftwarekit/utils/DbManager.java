package ec.edu.espe.viveresgabysoftwarekit.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ec.edu.espe.viveresgabysoftwarekit.controller.MongoHandler;
import ec.edu.espe.viveresgabysoftwarekit.model.Product;
import org.bson.Document;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import java.util.stream.Collectors;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego
 * García-HONEYBUDGERS-DCCO-14575
 */

public class DbManager<T> extends FileHandler implements SimpleCrudOperation<T> {

    @Override
    public List<T> readJSONListGeneric(String collectionName, Class<T> classTarget) {
        MongoHandler.conectToDb();

        MongoDatabase database = MongoHandler.mongoClient.getDatabase(Constans.DATA_BASE);
        MongoCollection<Document> collection = database.getCollection(collectionName);

        List<Document> fullTable = collection.find().into(new ArrayList<>());
        List<T> customersFromDataBase = new ArrayList<>();

        for (Document doc : fullTable) {
            Type type = TypeToken.getParameterized(classTarget).getType();

            customersFromDataBase.add(new Gson().fromJson(doc.toJson(), type));
        }
        return customersFromDataBase;
    }

    @Override
    public void saveCollection(List<T> templateList, String collectionName) {
        MongoHandler.mongoClient.getDatabase(Constans.DATA_BASE).getCollection(collectionName).drop();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(templateList);
        List<Document> documents = templateList.stream().map(template -> Document.parse(gson.toJson(template))).collect(Collectors.toList());
        
        MongoHandler.mongoClient.getDatabase(Constans.DATA_BASE).getCollection(collectionName).insertMany(documents);
    }
    
    

    
}
