package ec.edu.espe.viveresgabysoftwarekit.model;

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

            optionInventory = obtainOptionInventory();

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

            optionProduct = obtainOptionInventory();

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
            List<String> displayedProducts = new ArrayList<>();
            for (Product product : productList) {
                String productName = product.getName();
                if (!displayedProducts.contains(productName)) {
                    displayedProducts.add(productName);
                    int currentStock = productStock.getOrDefault(productName, 0);

                    System.out.println("Product: " + productName);
                    System.out.println("Current Stock: " + currentStock);
                    System.out.println("-------------------------");
                }
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
        int optionFindProduct;
        do {
            System.out.println("----- Find Product -----");
            System.out.println("1. Product");
            System.out.println("2. Back");
            System.out.print("Choose an option (1-2): ");

            optionFindProduct = obtainOptionInventory();

            switch (optionFindProduct) {
                case 1:
                    System.out.print("Enter the name of the product: ");
                    String productName = scanner.nextLine();
                    displayProductInfo(productName);
                    break;
                case 2:
                    System.out.println("Returning to the previous menu");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (optionFindProduct != 2);
    }

    private void displayProductInfo(String productName) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(productName)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Product not found with the name: " + productName);
    }

    private void displayAddProductMenu() {
        do {
            System.out.println("----- Add Product -----");

            String productName = validateStringInput("Enter the name of the product: ");
            double cost = validateDoubleInput("Enter the cost of the product: ");
            double pvp = validateDoubleInput("Enter the PVP of the product: ");
            String description = validateStringInput("Enter the description of the product: ");
            String provider = validateStringInput("Enter the provider of the product: ");
            String category = validateStringInput("Enter the category of the product: ");

            Product newProduct = new Product(productName, cost, pvp, description, provider, category);
            productList.add(newProduct);

            int currentStock = productStock.getOrDefault(productName, 0);
            productStock.put(productName, currentStock + 1);

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
        System.out.print("Enter the name of the product to delete: ");
        String productName = scanner.nextLine();

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

            optionCategory = obtainOptionInventory();

            switch (optionCategory) {
                case 1:
                    displaySeeAllCategoriesMenu();
                    break;
                case 2:
                    displayFindCategoryMenu();
                    break;
                case 3:
                    System.out.println("You selected Add category");
                    break;
                case 4:
                    displayDeleteCategoryMenu();
                    break;
                case 5:
                    System.out.println("Returning to the Inventory menu");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (optionCategory != 5);
    }
    
    private void displaySeeAllCategoriesMenu() {
        System.out.println("----- See All categories -----");

        if (categoryList.isEmpty()) {
            System.out.println("No categories added yet.");
        } else {
            List<String> displayedCategories = new ArrayList<>();
            for (Product product : productList) {
                String categoryName = product.getName();
                if (!displayedCategories.contains(categoryName)) {
                    displayedCategories.add(categoryName);
                    int currentStock = productStock.getOrDefault(categoryName, 0);

                    System.out.println("Category: " + categoryName);
                    System.out.println("Current Stock: " + currentStock);
                    System.out.println("-------------------------");
                }
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
        int optionFindCategory;
        do {
            System.out.println("----- Find category -----");
            System.out.println("1. Category");
            System.out.println("2. Back");
            System.out.print("Choose an option (1-2): ");

            optionFindCategory = obtainOptionInventory();

            switch (optionFindCategory) {
                case 1:
                    System.out.print("Enter the name of the category: ");
                    String categoryName = scanner.nextLine();
                    displayCategoryInfo(categoryName);
                    break;
                case 2:
                    System.out.println("Returning to the previous menu");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (optionFindCategory != 2);
    }

    private void displayCategoryInfo(String categoryName) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(categoryName)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Category not found with the name: " + categoryName);
    }

    private void displayAddCategoryMenu() {
        do {
            System.out.println("----- Add category -----");
            
            String productName = validateStringInput("Enter the name of the product: ");
            double cost = validateDoubleInput("Enter the cost of the product: ");
            double pvp = validateDoubleInput("Enter the PVP of the product: ");
            String description = validateStringInput("Enter the description of the product: ");
            String provider = validateStringInput("Enter the provider of the product: ");
            String category = validateStringInput("Enter the category of the product: ");

            Product newProduct = new Product(productName, cost, pvp, description, provider, category);
            productList.add(newProduct);

            int currentStock = productStock.getOrDefault(productName, 0);
            productStock.put(productName, currentStock + 1);

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

    private void displayDeleteCategoryMenu() {
        System.out.println("----- Delete Category -----");
        System.out.print("Enter the name of the category to delete: ");
        String categoryName = scanner.nextLine();

        boolean categoryFound = false;

        for (Category category : categoryList) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                categoryList.remove(category);
                categoryFound = true;
                break;
            }
        }

        if (categoryFound) {
            System.out.println("Product '" + categoryName + "' deleted successfully.");
            productStock.remove(categoryName);
        } else {
            System.out.println("Product not found with the name: " + categoryName);
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

            optionStock = obtainOptionInventory();

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

                int soldQuantity = validateSoldQuantity(productName, currentStock);
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

    private int validateSoldQuantity(String productName, int currentStock) {
        while (true) {
            System.out.print("Enter the quantity sold for product '" + productName + "': ");
            String input = scanner.nextLine();

            try {
                int soldQuantity = Integer.parseInt(input);

                if (soldQuantity >= 0 && soldQuantity <= currentStock) {
                    return soldQuantity;
                } else {
                    System.out.println("Invalid input, please enter a valid quantity (between 0 and " + currentStock + ").");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
    }

    private static String validateStringInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            if (input.matches("[a-zA-Z\\s]+")) {
                return input;
            } else {
                System.out.println("Invalid input, please enter letters only.");
            }
        }
    }

    private static double validateDoubleInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                double value = Double.parseDouble(input);

                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("Invalid input, please enter a non-negative number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
    }

    private static int obtainOptionInventory() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= 1 && input <= 5) {
                    return input;
                } else {
                    System.out.print("Invalid option, try again: ");
                    return 0; // Or any value that is not between 1 and 5
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }
}
