package ec.edu.espe.viveresgabysoftwarekit.model;

import java.util.Scanner;

public class InventoryMenu {

    private static Scanner scanner = new Scanner(System.in);
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
                    System.out.println("You selected See all products");
                    break;
                case 2:
                    System.out.println("You selected Find product");
                    break;
                case 3:
                    System.out.println("You selected Add product");
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
                    return 0; // O cualquier valor que no esté entre 1 y 5
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }
}
