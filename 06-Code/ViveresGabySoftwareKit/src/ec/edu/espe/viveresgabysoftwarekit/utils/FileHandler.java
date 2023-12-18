package ec.edu.espe.viveresgabysoftwarekit.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.viveresgabysoftwarekit.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;


import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class FileHandler<T> {

    public List<T> readJSONList(String path) {
        List<T> objectList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<User>>() {}.getType();
            objectList = new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public List<T> readJSONListStock(String path) {
        List<T> objectList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<SubStock>>() {}.getType();
            objectList = new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public List<T> readJSONListTransaction(String path) {
        List<T> objectList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<Transaction>>() {}.getType();
            objectList = new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public List<T> readJSONListProduct(String path) {
        List<T> objectList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<Product>>() {}.getType();
            objectList = new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public List<T> readJSONListProducts(String path) {
        List<T> objectList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<Product>>() {}.getType();
            objectList = new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectList;
    }


    public List<T> readJSONListCustomers(String path) {
        List<T> objectList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<Customer>>() {}.getType();
            objectList = new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public List<T> readJSONListCategorys(String path) {
        List<T> objectList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<Category>>() {}.getType();
            objectList = new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectList;
    }
    public List<T> readJSONListBills(String path) {
        List<T> objectList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<Bill>>() {}.getType();
            objectList = new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectList;
    }


    public List<T> readJSONListDiscounts(String path) {
        List<T> objectList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<Discount>>() {}.getType();
            objectList = new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectList;
    }




    public void saveJSONFile(List<T> templateList, String path) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(gson.toJson(templateList));
            System.out.println("[+]Data Saved Succesfully.");
        } catch (IOException e) {
            System.err.println("[-] Something went wrong: " + e.getMessage());
        }
    }

    public void saveTXTFile(String data, String path){
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

}



