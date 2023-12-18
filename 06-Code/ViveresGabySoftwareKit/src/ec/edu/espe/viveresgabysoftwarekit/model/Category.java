
package ec.edu.espe.viveresgabysoftwarekit.model;

import java.util.ArrayList;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */
public class Category {

    private int id;
    private String name;
    private String description;
    private ArrayList<Product> products;

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", description=" + description + ", products=" + products + '}';
    }


    public Category(String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String UICategoryinfo() {
        String info =
                "*********************************" + "\n" +
                        "\t\t" + name + "\n" +
                        "*********************************" + "\n" +
                        "Description: " + description + "\n";
        info += (products.isEmpty()) ? "No products in this category" : "Products in this category: " + products.size() + "\n";
        return info;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }


    public void addProductToCategory(Product product) {
    }

    public void deleteProductToCategory(Product product) {
    }


    public void getCategoryProducts() {
    }


    public void deleteCategory() {
    }

    ;
}
