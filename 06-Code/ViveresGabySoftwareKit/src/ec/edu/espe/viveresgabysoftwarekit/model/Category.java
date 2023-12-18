
package ec.edu.espe.viveresgabysoftwarekit.model;

import java.util.ArrayList;

/**
 *
 * @author mateo, Stefany Díaz
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

    public void UICategoryinfo(){
        System.out.println(
                "*********************************" + "\n" +
                        "\t\t" + name + "\n" +
                "*********************************" + "\n" +
                "Description: " + description + "\n" +
                "Products in this category: " +  products.size() + "\n"
        );
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
