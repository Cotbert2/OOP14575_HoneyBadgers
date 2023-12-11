package ec.edu.espe.viveresgabysoftwarekit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryMenu {

    private static Scanner scanner = new Scanner(System.in);
    private int optionInventory;
    private List<Product> productList = new ArrayList<>();

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
                    System.out.println("You selected Delete product");
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
            System.out.println("No products to display.");
        } else {
            for (Product product : productList) {
                System.out.println(product);
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
                System.out.println("Product information for " + productName);
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
            String provider = validateStringInputWithSpaces("Enter the provider of the product: ");
            String category = validateStringInputWithSpaces("Enter the category of the product: ");

            productList.add(new Product(productName, cost, pvp, description, provider, category));

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
                    System.out.println("You selected See all categories");
                    break;
                case 2:
                    System.out.println("You selected Find category");
                    break;
                case 3:
                    System.out.println("You selected Add category");
                    break;
                case 4:
                    System.out.println("You selected Delete category");
                    break;
                case 5:
                    System.out.println("Returning to the Inventory menu");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (optionCategory != 5);
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
                    System.out.println("You selected See stock");
                    break;
                case 2:
                    System.out.println("You selected Generate report");
                    break;
                case 3:
                    System.out.println("Returning to the previous menu");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (optionStock != 3);
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

    private String validateStringInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (input.matches("[a-zA-Z ]+")) {
                return input;
            } else {
                System.out.println("Invalid input, please enter only letters.");
            }
        }
    }

    private String validateStringInputWithSpaces(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (input.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
                return input;
            } else {
                System.out.println("Invalid input, please enter only letters.");
            }
        }
    }

    private double validateDoubleInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (input.matches("\\d+(\\.\\d+)?")) {
                return Double.parseDouble(input);
            } else {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        InventoryMenu inventoryMenu = new InventoryMenu();
        inventoryMenu.displayMenu();
    }
}
