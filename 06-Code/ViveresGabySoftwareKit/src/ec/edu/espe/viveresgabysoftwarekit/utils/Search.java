package ec.edu.espe.viveresgabysoftwarekit.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ec.edu.espe.viveresgabysoftwarekit.model.Product;

public class Search {

    FileHandler<Product> fileHandler = new FileHandler<>();
    public List<Product> findItem(String filepath, String name){
        List<Product> items = new ArrayList<>();
        List<Product> compatibleItem = new ArrayList<>();

        items = fileHandler.readJSONListProduct(filepath);
        for (Product item : items) {
            if(item.getName().contains(name))
                compatibleItem.add(item);
        }

        return compatibleItem;

    }
}
