package ec.edu.espe.viveresgabysoftwarekit.controller;

import ec.edu.espe.viveresgabysoftwarekit.model.Category;
import ec.edu.espe.viveresgabysoftwarekit.model.Product;
import ec.edu.espe.viveresgabysoftwarekit.utils.DbManager;
import java.util.ArrayList;
import java.util.List;
import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.model.Product;

/**
 *
 * @author mateo
 */
public class ProductHandler {

    private List<Product> productList = new ArrayList<>();
    DbManager<Category> DbHandler = new DbManager<>();
    Product product = new Product("", 0, 0, "", "");

    private void updateProduct() {
        productList = product.getProducts();
    }

    public List<Product> getProductList() {
        updateProduct();
        return productList;
    }
    
    
}
