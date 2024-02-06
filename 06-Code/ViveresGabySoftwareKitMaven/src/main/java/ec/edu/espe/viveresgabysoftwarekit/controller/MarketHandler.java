package ec.edu.espe.viveresgabysoftwarekit.controller;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.model.Customer;
import ec.edu.espe.viveresgabysoftwarekit.model.Product;
import ec.edu.espe.viveresgabysoftwarekit.model.ProductItem;

import ec.edu.espe.viveresgabysoftwarekit.utils.Search;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mateo
 */
public class MarketHandler {

    private static List<Product> items =  new ArrayList<>();
    
    private static List<ProductItem> kart = new ArrayList<>();

    private static Search finder = new Search();
    
    private static Customer customer;

    public List<Product> searchProduct(String name) {
        items = finder.findItem(Constans.PRODUCTS_FILE_NAME, name.toLowerCase());
        return items;
    }
    
    public void addToTheKart(ProductItem productItem){
        if(kart.isEmpty()){
            for(ProductItem registeredProduct : kart){
                if(productItem == registeredProduct){
                    registeredProduct.setUnits(registeredProduct.getUnits() + registeredProduct.getUnits());
                }
            
            }
        }
        kart.add(productItem);
    }

    public static List<ProductItem> getKart() {
        return kart;
    }

    public static void setCustomer(Customer customer) {
        MarketHandler.customer = customer;
    }
    
    public Customer getCustomerById(String id){
        return finder.findCustomer(Constans.CUSTOMERS_FILE_NAME, id.toLowerCase()).getFirst();
    }

    public static Customer getCustomer() {
        return customer;
    }

    public static List<Product> getItems() {
        return items;
    }
    
    
    
    
    
    
    
    
    
}
