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
    private ProductItem fullStorage[];
    private ProductItem OnCellar[];
    private ProductItem Onstore[];

    public Stock() {
        products = fileHandler.readJSONListProducts(Constans.PRODUCTS_FILE_NAME);
    }

    public ProductItem[] getFullStorage() {
        return fullStorage;
    }

    public void setFullStorage(ProductItem[] fullStorage) {
        this.fullStorage = fullStorage;
    }

    public ProductItem[] getOnCellar() {
        return OnCellar;
    }

    public void setOnCellar(ProductItem[] onCellar) {
        OnCellar = onCellar;
    }

    public ProductItem[] getOnstore() {
        return Onstore;
    }

    public void setOnstore(ProductItem[] onstore) {
        Onstore = onstore;
    }

    public String findProduct(String name){
        String productMessage = "Sorry, there is no product with that name";
        for (Product product : products) {
            if(product.getName().equals(name)){
                productMessage = product.toString();
            }
        }
        return productMessage;
    }

    public void viewStock() {
    }
    public void generateStocReport() {
    }
}
