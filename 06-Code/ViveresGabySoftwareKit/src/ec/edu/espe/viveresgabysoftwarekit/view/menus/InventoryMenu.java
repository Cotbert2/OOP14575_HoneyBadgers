package ec.edu.espe.viveresgabysoftwarekit.view.menus;

import ec.edu.espe.viveresgabysoftwarekit.model.*;
import ec.edu.espe.viveresgabysoftwarekit.utils.Search;
import ec.edu.espe.viveresgabysoftwarekit.utils.Validations;

import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ec.edu.espe.viveresgabysoftwarekit.utils.Validator;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class InventoryMenu {

    Validator validator = new Validator();
    Validations validations = new Validations();

    private static Scanner scanner = new Scanner(System.in);

    private List<Product> productList = new ArrayList<>();
    private Map<String, Integer> productStock = new HashMap<>();
    private List<Category> categoryList = new ArrayList<>();
    int optionInventory;


    FileHandler<Product> fileHandler = new FileHandler<>();
    FileHandler<Category> fileHandlerCategory = new FileHandler<>();
    Search finder = new Search();


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
            updateProduct();
            System.out.println("-----  Product Menu  -----");
            System.out.println("1. See all products");
            System.out.println("2. Find product");
            System.out.println("3. Add product");
            System.out.println("4. Edit product");
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
                    displayEditProductMenu();
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
        updateProduct();
        System.out.println("----- See All Products -----");

        if (productList.isEmpty()) {
            System.out.println("No products added yet.");
        } else {
            for (Product product : productList) {
                System.out.println(product.UIPrint());
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
        System.out.print("name: ");
        String keyToFind = scanner.nextLine();
        List<Product> productsFound = finder.findItem(Constans.PRODUCTS_FILE_NAME, keyToFind);
        for (Product product : productsFound) {
            System.out.println(product.UIPrint());
        }
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
        boolean response;
        do {
            System.out.println("----- Add Product -----");

            String productName = Validations.noValidationStr("Enter the name of the product: ");
            float cost = Validations.validateFloatInput("Enter the cost of the product: ");
            float pvp;
            do {
                pvp = Validations.validateFloatInput("Enter the PVP of the product: ");
                if (pvp < cost)
                    System.out.println("The PVP must be greater than the cost.");
            } while (pvp < cost);

            String description = Validations.noValidationStr("Enter the description of the product: ");
            String provider = Validations.noValidationStr("Enter the provider of the product: ");
            Product newProduct = new Product(productName, cost, pvp, description, provider);

            productList.add(newProduct);
            fileHandler.saveJSONFile(productList, Constans.PRODUCTS_FILE_NAME);

            SubStock newStockItem = new SubStock(newProduct, 0, 0);
            Stock stock = new Stock();
            stock.saveStocks(newStockItem);


            System.out.print("Do you want to add more products? (y/n): ");
            response = validator.getYNOption();
            if (response)
                System.out.println("Adding new product...");
        } while (response);
    }

    private void displayEditProductMenu() {
        System.out.println("----- Edit Product -----");
        int opt;
        List<Product> items;
        System.out.print("name: ");
        String productNameToFind = scanner.nextLine();
        items = finder.findItem(Constans.PRODUCTS_FILE_NAME, productNameToFind.toLowerCase());

        int index = 0;
        for (Product item : items) {
            System.out.println((index + 1) + ") \n" + item.UIPrint());
            index++;
        }
        do {
            System.out.print("option: ");
            opt = validator.getIntOption();
            if (opt < 1 || opt > items.size())
                System.out.println("Try again, invalid option");

        } while (opt < 1 || opt > items.size());

        productList.remove(finder.findItemPosition(Constans.PRODUCTS_FILE_NAME, items.get(opt - 1).getId()));

        String productName = Validations.validateStringInput("Enter the name of the product (" + items.get(opt - 1).getName() + "): ");
        double cost = Validations.validateDoubleInput("Enter the cost of the product (" + items.get(opt - 1).getCost() + "): ");
        double pvp = Validations.validateDoubleInput("Enter the PVP of the product (" + items.get(opt - 1).getPvp() + "): ");
        String description = Validations.validateStringInput("Enter the description of the product (" + items.get(opt - 1).getDescription() + "): ");
        String provider = Validations.validateStringInput("Enter the provider of the product (" + items.get(opt - 1).getProvider() + "): ");
        Product editedProduct = new Product(productName, cost, pvp, description, provider);
        editedProduct.setId(items.get(opt - 1).getId());
        productList.add(editedProduct);
        fileHandler.saveJSONFile(productList, Constans.PRODUCTS_FILE_NAME);
        System.out.println("[+] Product edited successfully.");
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

        categoryList = fileHandlerCategory.readJSONListCategorys(Constans.CATEGORIES_FILE_NAME);

        if (categoryList.isEmpty()) {
            System.out.println("No categories added yet.");
        } else {
            int index = 0;
            for (Category category : categoryList) {
                System.out.println((index + 1) + ")");
                System.out.println(category.UICategoryinfo());
                index++;
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
        String searchKeyword = Validations.validateStringInput("name: ");
        findCategory(searchKeyword);
    }

    private void findCategory(String searchKeyword) {
        System.out.println("----- Search Results -----");

        boolean found = false;

        for (Category category : categoryList) {
            if (category.getName().toLowerCase().contains(searchKeyword.toLowerCase())) {
                System.out.println(category.UICategoryinfo());
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
        updateCategory();
        System.out.println("----- Add Category -----");
        String categoryName = Validations.validateStringInput("Enter the name of the category: ");
        String description = Validations.validateStringInput("Enter the description of the category: ");
        Category newCategory = new Category(categoryName, description);
        categoryList.add(newCategory);
        fileHandlerCategory.saveJSONFile(categoryList, Constans.CATEGORIES_FILE_NAME);
        System.out.println("Category '" + categoryName + "' added successfully.");
        System.out.println("Returning to the previous menu");
    }

    private void displayDeleteCategoryMenu() {
        System.out.println("----- Delete Category -----");
        String categoryName = Validations.validateStringInput("Enter the name of the category to delete: ");
        deleteCategory(categoryName);
    }

    private void deleteCategory(String categoryName) {
        int index = 0;
        for (Category items : categoryList) {
            if (items.getName().toLowerCase().contains(categoryName.toLowerCase())) {
                System.out.println((index + 1) + ") ");
                System.out.println(items.UICategoryinfo());
                index++;
            }
        }
        categoryList.remove(validator.getIntOption() - 1);

    }

    private void displayStockMenu() {
        int optionStock;
        do {
            System.out.println("-----  Stock Menu  -----");
            System.out.println("1. See stock");
            System.out.println("2. Generate report");
            System.out.println("3. Add stock to a product");
            System.out.println("4. Back");
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
                    addStockToProduct();
                    break;
                case 4:
                    System.out.println("Returning to the previous menu");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (optionStock != 4);
    }

    private void displaySeeStockMenu() {
        Stock stock = new Stock();
        //header
        System.out.println("----- See Stock -----");
        System.out.println("Id" + "\tName" + "\tGrocery Units" + "\tStorage Units" + "\tFull storage\n");
        for (SubStock subStock : stock.getStocks()) {
            System.out.println(subStock.UIPrint());
        }

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
        Stock stock = new Stock();
        stock.generateStockReport();
        System.out.println("Generatirng report...");
    }

    public void addStockToProduct() {
        Stock stock = new Stock();
        System.out.println("----- Add Stock to a Product -----");
        //Menu Select to grocery or storage
        int opt = 0;
        int id = 0;
        int units = 0;
        do {
            System.out.println("1. Add stock to grocery");
            System.out.println("2. Add stock to storage");
            System.out.print("option: ");
            opt = validator.getIntOption();
            if (opt == 1 || opt == 2) {
                System.out.println("Enter the id of the product: ");
                id = Validations.obtainOptionInventory();
                System.out.println("Enter the units to add: ");
                units = Validations.obtainOptionInventory();
            }
            switch (opt) {
                case 1:
                    System.out.println("Adding stock to grocery");
                    stock.addStockToGrocery(id, units);
                    break;
                case 2:
                    System.out.println("Adding stock to storage");
                    stock.addStockToWarehouse(id, units);
                    break;
                default:
                    System.out.println("Try again, invalid option");
            }
            if (opt < 1 || opt > 2)
                System.out.println("Try again, invalid option");
        } while (opt < 1 || opt > 2);
        System.out.println("Stock added successfully");
    }

    private void updateProduct() {
        productList = fileHandler.readJSONListProducts(Constans.PRODUCTS_FILE_NAME);
    }

    public void updateCategory() {
        categoryList = fileHandlerCategory.readJSONListCategorys(Constans.CATEGORIES_FILE_NAME);
    }
}

