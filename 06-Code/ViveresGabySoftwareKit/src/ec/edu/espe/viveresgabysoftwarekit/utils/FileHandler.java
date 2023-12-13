package ec.edu.espe.viveresgabysoftwarekit.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

public class FileHandler<objectAdapater> {

    List<objectAdapater> chickens = new ArrayList<>();

    public static void printCSVFile(String path) {
        try (BufferedReader _buffer = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = _buffer.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("| id: " + data[0] + " |name: " + data[1] + " |color: " + data[2] + " |age: " + data[3] + " |isMolting: " + data[4] + " |bornOnDate: " + data[5] + "|");
            }
        } catch (IOException e) {
            System.err.println("[-] Something went wrong: " + e.getMessage());
        }
    }

    public static int getLastId(String path) {
        int lastId = 0;
        try (BufferedReader _buffer = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = _buffer.readLine()) != null) {
                String[] data = line.split(",");
                lastId = Integer.parseInt(data[0]);
            }
        } catch (IOException e) {
            System.err.println("[-] Something went wrong: " + e.getMessage());
        }
        return (lastId + 1);
    }

    public void saveCSVFile(objectAdapater object0, String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(object0.toString());
            System.out.println("[+]Data Saved Succesfully.");
        } catch (IOException e) {
            System.err.println("[-] Something went wrong: " + e.getMessage());
        }
    }

    public void readJSONFile(String path) {
        String file = "";

        try (BufferedReader _buffer = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = _buffer.readLine()) != null) {
                file += line;
            }
            _buffer.close();
        } catch (IOException e) {
            System.err.println("[-] Something went wrong: " + e.getMessage());
        }
        System.out.println(file);
        Type listType = new TypeToken<ArrayList<objectAdapater>>() {}.getType();
        objectAdapater chicken = new Gson().fromJson(file, listType);
        System.out.println(chicken);

    }

    public List<User> readJSONList(String path) {
        List<User> objectList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<User>>() {}.getType();
            objectList = new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public objectAdapater updateJSONInfo(String path) {
        String file = "";

        try (BufferedReader _buffer = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = _buffer.readLine()) != null) {
                file += line;
            }
            _buffer.close();
        } catch (IOException e) {
            System.err.println("[-] Something went wrong: " + e.getMessage());
        }
        System.out.println(file);
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<User>>() {}.getType();

        return gson.fromJson(file, listType);
    }

    public void saveJSONFile(ArrayList<objectAdapater> chikens, String path) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(gson.toJson(chikens));
            System.out.println("[+]Data Saved Succesfully.");
        } catch (IOException e) {
            System.err.println("[-] Something went wrong: " + e.getMessage());
        }
    }

}



