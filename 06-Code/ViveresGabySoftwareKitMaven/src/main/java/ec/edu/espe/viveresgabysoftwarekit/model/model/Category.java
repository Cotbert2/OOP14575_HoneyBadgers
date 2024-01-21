
package ec.edu.espe.viveresgabysoftwarekit.model.model;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;

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
        info += (products == null) ? "No products in this category" : "Products in this category: " + products.size() + "\n";
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


    public void addProductToCategory(int id, Product product) {
        List<Category> categories = getCategories();
        categories.forEach(category -> {
            if (category.getId() == id) {
                category.getProducts().forEach(
                        product1 -> {
                            if (product1.getId() == product.getId()) {
                                System.out.println("[-] Product already in category");
                                return;
                            }
                        }
                );
                category.getProducts().add(product);
                System.out.println("[+] Product added to category");
            }
        });
        saveFullCategoriesList(categories);

    }


    public void getCategoryProducts() {
    }


    public void deleteProductToCategory(Product product) {
        products.remove(product);
    }


    public void saveFullCategoriesList(List<Category> categories) {
        FileHandler<Category> fileHandler = new FileHandler<>();
        fileHandler.saveJSONFile(categories, Constans.CATEGORIES_FILE_NAME);
    }

    public List<Category> getCategories() {
        FileHandler<Category> fileHandler = new FileHandler<>();
        return fileHandler.readJSONListGeneric(Constans.CATEGORIES_FILE_NAME, Category.class);
    }

    public void saveCategory(Category category) {
        FileHandler<Category> fileHandler = new FileHandler<>();
        List<Category> categories = getCategories();
        categories.add(category);
        fileHandler.saveJSONFile(categories, Constans.CATEGORIES_FILE_NAME);
    }

}

