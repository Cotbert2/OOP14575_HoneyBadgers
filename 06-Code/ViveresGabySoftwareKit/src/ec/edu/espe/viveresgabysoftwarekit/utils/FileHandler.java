package ec.edu.espe.viveresgabysoftwarekit.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.viveresgabysoftwarekit.helpers.TypeGenerator;
import ec.edu.espe.viveresgabysoftwarekit.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;


import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class FileHandler<T> {



    public List<T> readJSONListTax(String path) {
        List<T> objectList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<Tax>>() {
            }.getType();
            objectList = new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public List<T> readJSONListGeneric(String path, Class<T> classTarget) {
        List<T> objectList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Type listType = new ListParameterizedType(classTarget);
            objectList = new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (objectList == null) {
            objectList = new ArrayList<>();
            this.saveJSONFile(objectList, path);
            this.readJSONListGeneric(path, classTarget);
        }
        return objectList;
    }


    public void saveJSONFile(List<T> templateList, String path) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(gson.toJson(templateList));
            System.out.println("[+]Data Saved Succesfully.");
        } catch (IOException e) {
            System.err.println("[-] Something went wrong: " + e.getMessage());
        }
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