package ec.edu.espe.viveresgabysoftwarekit.utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ec.edu.espe.viveresgabysoftwarekit.model.Category;
import ec.edu.espe.viveresgabysoftwarekit.model.Customer;
import ec.edu.espe.viveresgabysoftwarekit.model.Product;

public class Search {

    FileHandler<Product> fileHandler = new FileHandler<>();
    FileHandler<Customer> fileHandlerCustomer = new FileHandler<>();

    FileHandler<Category> fileHandlerCategory = new FileHandler<>();

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

    public int findItemPosition(String filepath, int id){
        int index = 0;
        int indexToEdit = 0;
        List<Product> items = new ArrayList<>();
        List<Product> compatibleItem = new ArrayList<>();

        items = fileHandler.readJSONListProduct(filepath);
        for (Product item : items) {
            if(item.getId() == id)
                indexToEdit = index;
            index++;
        }
        return indexToEdit;
    }

    public List<Category> findCategory(String filepath, String name){
        List<Category> items = new ArrayList<>();
        List<Category> compatibleItem = new ArrayList<>();

        items = fileHandlerCategory.readJSONListCategorys(filepath);
        for (Category item : items) {
            if(item.getName().contains(name))
                compatibleItem.add(item);
        }

        return compatibleItem;

    }

    public List<Customer> findCustomer(String filepath, String name){
        List<Customer> items = new ArrayList<>();
        List<Customer> compatibleItem = new ArrayList<>();

        items = fileHandlerCustomer.readJSONListCustomers(filepath);

        for (Customer customer : items) {
            if( Integer.toString(customer.getId()).contains(name))
                compatibleItem.add(customer);
        }

        return compatibleItem;

    }

    public ArrayList<Category> splitCategory(ArrayList<Category> categories, int id){
        int index = 0;
        int indexToSplit = 0;
        for(Category category : categories){
            if(category.getId() == id){
                indexToSplit = index;
            }
            index++;
        }
        categories.remove(indexToSplit);
        return categories;

    }
}
