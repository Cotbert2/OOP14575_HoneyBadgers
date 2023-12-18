package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateo, Stefany Díaz
 */
public class Stock {
    List<Product> products;
    FileHandler<Product> fileHandler = new FileHandler<>();

    private ArrayList<ProductItem> fullStorage;
    private ArrayList<ProductItem> onGrocery;
    private ArrayList<ProductItem> onStore;
    public Stock() {
        products = fileHandler.readJSONListProducts(Constans.PRODUCTS_FILE_NAME);
    }



    public String findProduct(String name){
        String productMessage = "Sorry, there is no product with that namek\n 1) Search Again\n2) Back\nOption:";
        for (Product product : products) {
            if(product.getName().equals(name)){
                productMessage = product.UIPrint();
            }
        }
        return productMessage;
    }

    public void viewStock() {
    }
    public void generateStocReport() {
    }
}
