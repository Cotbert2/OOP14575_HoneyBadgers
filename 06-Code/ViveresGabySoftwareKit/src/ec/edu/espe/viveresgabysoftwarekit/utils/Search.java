package ec.edu.espe.viveresgabysoftwarekit.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ec.edu.espe.viveresgabysoftwarekit.model.Customer;
import ec.edu.espe.viveresgabysoftwarekit.model.Product;

public class Search {

    FileHandler<Product> fileHandler = new FileHandler<>();
    FileHandler<Customer> fileHandlerCustomer = new FileHandler<>();

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
}
