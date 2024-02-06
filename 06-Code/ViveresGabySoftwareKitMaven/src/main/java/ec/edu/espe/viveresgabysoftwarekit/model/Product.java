
package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.controller.Db;
import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.utils.DbManager;
import ec.edu.espe.viveresgabysoftwarekit.utils.Search;

import java.io.Serializable;
import java.util.List;


/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Mateo García-HONEYBUDGERS-DCCO-14575
 */

public class Product implements Serializable {
    private int id;
    private String name;
    private double cost;
    private double pvp;
    private String description;
    private String provider;

    public Product(String name, double cost, double pvp, String description, String provider) {
        this.id = getProducts().getLast().getId() + 1;
        this.name = name;
        this.cost = cost;
        this.pvp = pvp;
        this.description = description;
        this.provider = provider;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the pvp
     */
    public double getPvp() {
        return pvp;
    }

    /**
     * @param pvp the pvp to set
     */
    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the provider
     */
    public String getProvider() {
        return provider;
    }

    /**
     * @param provider the provider to set
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", cost=" + cost + ", pvp=" + pvp + ", description=" + description + ", provider=" + provider + '}';
    }

    public String UIPrint() {
        return "-----------------------------------\n" + "Name: " + name + "\n-----------------------------------\n" + "Cost: " + cost + "\n" + "PVP: " + pvp + "\n" + "Description: " + description + "\n" + "Provider: " + provider + "\n" + "-----------------------------------\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        DbManager<Product> fileHandler = new DbManager<>();
        return fileHandler.readJSONListGeneric(Constans.PRODUCTS_FILE_NAME, Product.class);
    }

    public void editProduct(int id, Product product) {
        List<Product> productList = getProducts();
        Search finder = new Search();
        productList.remove(finder.findItemPosition(Constans.PRODUCTS_FILE_NAME, id));
        product.setId(id);
        productList.add(product);
        DbManager<Product> fileHandler = new DbManager<>();
        fileHandler.saveCollection(productList, Constans.PRODUCTS_FILE_NAME);
        Stock stock = new Stock();
        List<SubStock> currentStock = stock.getStocks();
        currentStock.forEach((subStock) -> {
            if (subStock.getProduct().getId() == id) {
                subStock.setProduct(product);
            }
        });
        stock.saveStockFullList(currentStock);

        System.out.println("[+] Product edited successfully.");
    }

    public void saveProduct(Product product) {
        DbManager<Product> fileHandler = new DbManager<>();
        List<Product> products = getProducts();
        products.add(product);
        fileHandler.saveCollection(products, Constans.PRODUCTS_FILE_NAME);
    }
}
   
    
