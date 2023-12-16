package ec.edu.espe.viveresgabysoftwarekit.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.viveresgabysoftwarekit.model.Customer;
import ec.edu.espe.viveresgabysoftwarekit.model.Product;
import ec.edu.espe.viveresgabysoftwarekit.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateo
 */

public class FileHandler<T> {

    List<T> chickens = new ArrayList<>();




    //retorna una lista con todoa la base de datos
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
    public void saveJSONFile(List<T> templateList, String path) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(gson.toJson(templateList));
            System.out.println("[+]Data Saved Succesfully.");
        } catch (IOException e) {
            System.err.println("[-] Something went wrong: " + e.getMessage());
        }
    }
}



