package ec.edu.espe.viveresgabysoftwarekit.view;

import ec.edu.espe.viveresgabysoftwarekit.model.Category;
import ec.edu.espe.viveresgabysoftwarekit.model.Product;
import ec.edu.espe.viveresgabysoftwarekit.utils.Validations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InventoryMenu {

    private static Scanner scanner = new Scanner(System.in);

    private List<Product> productList = new ArrayList<>();
    private Map<String, Integer> productStock = new HashMap<>();
    private List<Category> categoryList = new ArrayList<>();
    int optionInventory;

    public void displayMenu() {
        do {
            System.out.println("-----  Inventory Menu  -----");
            System.out.println("1. Product");
            System.out.println("2. Category");
            System.out.println("3. Stock");
            System.out.println("4. Back");
            System.out.print("Choose an option (1-4): ");

            optionInventory = Validations.obtainOptionInventory();

            switch (optionInventory) {
                case 1:
                    displayProductMenu();
                    break;
                case 2:
                    displayCategoryMenu();
                    break;
                case 3:
                    displayStockMenu();
                    break;
                case 4:
                    System.out.println("Returning to the previous menu");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (optionInventory != 4);
    }

    private void displayProductMenu() {
        int optionProduct;
        do {
            System.out.println("-----  Product Menu  -----");
            System.out.println("1. See all products");
            System.out.println("2. Find product");
            System.out.println("3. Add product");
            System.out.println("4. Delete product");
            System.out.println("5. Back");
            System.out.print("Choose an option (1-5): ");

            optionProduct = Validations.obtainOptionInventory();

            switch (optionProduct) {
                case 1:
                    displaySeeAllProductsMenu();
                    break;
                case 2:
                    displayFindProductMenu();
                    break;
                case 3:
                    displayAddProductMenu();
                    break;
                case 4:
                    displayDeleteProductMenu();
                    break;
                case 5:
                    System.out.println("Returning to the previous menu");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (optionProduct != 5);
    }

    private void displaySeeAllProductsMenu() {
        System.out.println("----- See All Products -----");

        if (productList.isEmpty()) {
            System.out.println("No products added yet.");
        } else {
            for (Product product : productList) {
                String productName = product.getName();
                int currentStock = productStock.getOrDefault(productName, 0);

                System.out.println("Product: " + productName);
                System.out.println("Current Stock: " + currentStock);
                System.out.println("-------------------------");
            }
        }

        System.out.println("Press 'B' to go back to the previous menu.");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("B")) {
            System.out.println("Returning to the previous menu");
        } else {
            System.out.println("Invalid option, returning to the previous menu");
        }
    }

    private void displayFindProductMenu() {
        System.out.println("----- Find Product -----");
        String searchKeyword = Validations.validateStringInput("Enter the keyword to search for a product: ");
        findProduct(searchKeyword);
    }

    private void findProduct(String searchKeyword) {
        System.out.println("----- Search Results -----");

        boolean found = false;

        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(searchKeyword.toLowerCase())) {
                System.out.println(product);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found with the keyword: " + searchKeyword);
        }

        System.out.println("Press 'B' to go back to the previous menu.");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("B")) {
            System.out.println("Returning to the previous menu");
        } else {
            System.out.println("Invalid option, returning to the previous menu");
        }
    }

    private void displayAddProductMenu() {
        do {
            System.out.println("----- Add Product -----");

            String productName = Validations.validateStringInput("Enter the name of the product: ");
            double cost = Validations.validateDoubleInput("Enter the cost of the product: ");
            double pvp = Validations.validateDoubleInput("Enter the PVP of the product: ");
            String description = Validations.validateStringInput("Enter the description of the product: ");
            String provider = Validations.validateStringInput("Enter the provider of the product: ");
            String category = Validations.validateStringInput("Enter the category of the product: ");

            int quantity = Validations.validateProductQuantity();

            Product newProduct = new Product(productName, cost, pvp, description, provider, category);

            productList.add(newProduct);

            int currentStock = productStock.getOrDefault(productName, 0);
            productStock.put(productName, currentStock + quantity);

            System.out.print("Do you want to add more products? (yes/no): ");
            String addMore = scanner.nextLine();

            if (addMore.equalsIgnoreCase("no")) {
                System.out.println("Returning to the previous menu");
                break;
            } else if (!addMore.equalsIgnoreCase("yes")) {
                System.out.println("Invalid option, returning to the previous menu");
                break;
            }
        } while (true);
    }

    private void displayDeleteProductMenu() {
        System.out.println("----- Delete Product -----");
        String productName = Validations.validateStringInput("Enter the name of the product to delete: ");
        deleteProduct(productName);
    }

    private void deleteProduct(String productName) {
        boolean productFound = false;

        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(productName)) {
                productList.remove(product);
                productFound = true;
                break;
            }
        }

        if (productFound) {
            System.out.println("Product '" + productName + "' deleted successfully.");
            productStock.remove(productName);
        } else {
            System.out.println("Product not found with the name: " + productName);
        }
    }

    private void displayCategoryMenu() {
        int optionCategory;
        do {
            System.out.println("-----  Category Menu  -----");
            System.out.println("1. See all categories");
            System.out.println("2. Find category");
            System.out.println("3. Add category");
            System.out.println("4. Delete category");
            System.out.println("5. Back");
            System.out.print("Choose an option (1-5): ");

            optionCategory = Validations.obtainOptionInventory();

            switch (optionCategory) {
                case 1:
                    displaySeeAllCategoriesMenu();
                    break;
                case 2:
                    displayFindCategoryMenu();
                    break;
                case 3:
                    displayAddCategoryMenu();
                    break;
                case 4:
                    displayDeleteCategoryMenu();
                    break;
                case 5:
                    System.out.println("Returning to the previous menu");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (optionCategory != 5);
    }

    private void displaySeeAllCategoriesMenu() {
        System.out.println("----- See All Categories -----");

        if (categoryList.isEmpty()) {
            System.out.println("No categories added yet.");
        } else {
            for (Category category : categoryList) {
                System.out.println("Category: " + category.getName());
                System.out.println("-------------------------");
            }
        }

        System.out.println("Press 'B' to go back to the previous menu.");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("B")) {
            System.out.println("Returning to the previous menu");
        } else {
            System.out.println("Invalid option, returning to the previous menu");
        }
    }

    private void displayFindCategoryMenu() {
        System.out.println("----- Find Category -----");
        String searchKeyword = Validations.validateStringInput("Enter the keyword to search for a category: ");
        findCategory(searchKeyword);
    }

    private void findCategory(String searchKeyword) {
        System.out.println("----- Search Results -----");

        boolean found = false;

        for (Category category : categoryList) {
            if (category.getName().toLowerCase().contains(searchKeyword.toLowerCase())) {
                System.out.println(category);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No categories found with the keyword: " + searchKeyword);
        }

        System.out.println("Press 'B' to go back to the previous menu.");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("B")) {
            System.out.println("Returning to the previous menu");
        } else {
            System.out.println("Invalid option, returning to the previous menu");
        }
    }

    private void displayAddCategoryMenu() {
        System.out.println("----- Add Category -----");
        String categoryName = Validations.validateStringInput("Enter the name of the category: ");
        Category newCategory = new Category(categoryName);
        categoryList.add(newCategory);
        System.out.println("Category '" + categoryName + "' added successfully.");
        System.out.println("Returning to the previous menu");
    }

    private void displayDeleteCategoryMenu() {
        System.out.println("----- Delete Category -----");
        String categoryName = Validations.validateStringInput("Enter the name of the category to delete: ");
        deleteCategory(categoryName);
    }

    private void deleteCategory(String categoryName) {
        boolean categoryFound = false;

        for (Category category : categoryList) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                categoryList.remove(category);
                categoryFound = true;
                break;
            }
        }

        if (categoryFound) {
            System.out.println("Category '" + categoryName + "' deleted successfully.");
        } else {
            System.out.println("Category not found with the name: " + categoryName);
        }
    }

    private void displayStockMenu() {
        int optionStock;
        do {
            System.out.println("-----  Stock Menu  -----");
            System.out.println("1. See stock");
            System.out.println("2. Generate report");
            System.out.println("3. Back");
            System.out.print("Choose an option (1-3): ");

            optionStock = Validations.obtainOptionInventory();

            switch (optionStock) {
                case 1:
                    displaySeeStockMenu();
                    break;
                case 2:
                    generateReport();
                    break;
                case 3:
                    System.out.println("Returning to the previous menu");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (optionStock != 3);
    }

    private void displaySeeStockMenu() {
        System.out.println("----- See Stock -----");

        if (productList.isEmpty()) {
            System.out.println("No products added yet.");
        } else {
            for (Product product : productList) {
                String productName = product.getName();
                int currentStock = productStock.getOrDefault(productName, 0);

                System.out.println("Product: " + productName);
                System.out.println("Current Stock: " + currentStock);
                System.out.println("-------------------------");
            }
        }

        System.out.println("Press 'B' to go back to the previous menu.");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("B")) {
            System.out.println("Returning to the previous menu");
        } else {
            System.out.println("Invalid option, returning to the previous menu");
        }
    }

    private void generateReport() {
        System.out.println("----- Generate Report -----");

        if (productList.isEmpty()) {
            System.out.println("No products to generate a report.");
        } else {
            System.out.print("Enter the name of the product to generate a report: ");
            String productName = scanner.nextLine();

            Product selectedProduct = null;
            for (Product product : productList) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    selectedProduct = product;
                    break;
                }
            }

            if (selectedProduct != null) {
                int currentStock = productStock.getOrDefault(productName, 0);
                System.out.println("Current Stock: " + currentStock);

                int soldQuantity = Validations.validateSoldQuantity(productName, currentStock);
                productStock.put(productName, currentStock - soldQuantity);

                System.out.println("Sold Quantity: " + soldQuantity);
                System.out.println("Updated Stock: " + productStock.get(productName));

                if (currentStock == 0) {
                    System.out.println("Warning: Product '" + productName + "' is out of stock.");
                }

                System.out.println("-------------------------");
            } else {
                System.out.println("Product not found with the name: " + productName);
            }
        }

        System.out.println("Press 'B' to go back to the previous menu.");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("B")) {
            System.out.println("Returning to the previous menu");
        } else {
            System.out.println("Invalid option, returning to the previous menu");
        }
    }
}

