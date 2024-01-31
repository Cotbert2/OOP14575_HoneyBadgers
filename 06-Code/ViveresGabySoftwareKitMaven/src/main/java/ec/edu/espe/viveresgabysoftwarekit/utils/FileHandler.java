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

import ec.edu.espe.viveresgabysoftwarekit.controller.Db;
import ec.edu.espe.viveresgabysoftwarekit.model.Product;
import org.bson.Document;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import java.util.stream.Collectors;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego
 * García-HONEYBUDGERS-DCCO-14575
 */

public class FileHandler<T> {

    public List<T> readJSONListGeneric(String collectionName, Class<T> classTarget) {
        Db.conectToDb();

        MongoDatabase database = Db.mongoClient.getDatabase(Constans.DATA_BASE);
        MongoCollection<Document> collection = database.getCollection(collectionName);

        List<Document> fullTable = collection.find().into(new ArrayList<>());
        List<T> customersFromDataBase = new ArrayList<>();

        for (Document doc : fullTable) {
            Type type = TypeToken.getParameterized(classTarget).getType();

            customersFromDataBase.add(new Gson().fromJson(doc.toJson(), type));
        }
        return customersFromDataBase;
    }

    public void saveJSONFile(List<T> templateList, String collectionName) {
        Db.mongoClient.getDatabase(Constans.DATA_BASE).getCollection(collectionName).drop();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(templateList);
        List<Document> documents = templateList.stream().map(template -> Document.parse(gson.toJson(template))).collect(Collectors.toList());
        
        Db.mongoClient.getDatabase(Constans.DATA_BASE).getCollection(collectionName).insertMany(documents);
    }
    
    

    public void saveTXTFile(String data, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
            System.out.println("File Created Successfully");
        } catch (IOException e) {
            System.out.println("Something went wrong creating the file: " + e.getMessage());
        }
    }

    public String getDesktopPath() {
        return System.getProperty("user.home") + "/Desktop";
    }

    private static class ListParameterizedType implements ParameterizedType {

        private final Type type;

        private ListParameterizedType(Class<?> type) {
            this.type = type;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{type};
        }

        @Override
        public Type getRawType() {
            return ArrayList.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }

}
