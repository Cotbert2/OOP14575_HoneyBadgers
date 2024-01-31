package ec.edu.espe.viveresgabysoftwarekit.view.menus;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.utils.DbManager;
import ec.edu.espe.viveresgabysoftwarekit.utils.Search;
import ec.edu.espe.viveresgabysoftwarekit.utils.Validations;

import java.util.*;
import ec.edu.espe.viveresgabysoftwarekit.model.*;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class InventoryMenu {

    Validations validations = new Validations();

    Category category = new Category("", "");
    Product product = new Product("", 0, 0, "", "");

    private static Scanner scanner = new Scanner(System.in);

    private List<Product> productList = new ArrayList<>();
    private Map<String, Integer> productStock = new HashMap<>();
    private List<Category> categoryList = new ArrayList<>();
    int optionInventory;


    DbManager<Category> fileHandlerCategory = new DbManager<>();
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

        validations.waitForEnter();
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

        validations.waitForEnter();
    }

    private void displayAddProductMenu() {
        boolean response;
        do {
            System.out.println("----- Add Product -----");

            String productName = Validations.getNoValidationStr("Enter the name of the product: ");
            float cost = Validations.validateFloatInput("Enter the cost of the product: ");
            float pvp;
            do {
                pvp = Validations.validateFloatInput("Enter the PVP of the product: ");
                if (pvp < cost)
                    System.out.println("The PVP must be greater than the cost.");
            } while (pvp < cost);

            String description = Validations.getNoValidationStr("Enter the description of the product: ");
            String provider = Validations.getNoValidationStr("Enter the provider of the product: ");
            Product newProduct = new Product(productName, cost, pvp, description, provider);



            newProduct.saveProduct(newProduct);

            SubStock newStockItem = new SubStock(newProduct, 0, 0);
            Stock stock = new Stock();
            stock.saveStocks(newStockItem);


            response = validations.getYNOption("Do you want to add more products? (y/n): ");
            if (response)
                System.out.println("Adding new product...");
        } while (response);
    }

    private void displayEditProductMenu() {
        System.out.println("----- Edit Product -----");
        int opt;
        List<Product> items;
        String productNameToFind = Validations.getNoValidationLongStr("name: ");

        items = finder.findItem(Constans.PRODUCTS_FILE_NAME, productNameToFind.toLowerCase());

        if(items.isEmpty()) {
            System.out.println("Sorry, there is no product with that name");
            return;
        }
        int index = 0;
        for (Product item : items) {
            System.out.println((index + 1) + ") \n" + item.UIPrint());
            index++;
        }
        do {
            opt = validations.getIntOption("option: ");
            if (opt < 1 || opt > items.size())
                System.out.println("Try again, invalid option");

        } while (opt < 1 || opt > items.size());

        String productName = Validations.getNoValidationStr("Enter the name of the product (" + items.get(opt - 1).getName() + "): ");
        float cost = Validations.validateFloatInput("Enter the cost of the product (" + items.get(opt - 1).getCost() + "): ");
        float pvp = Validations.validateFloatInput("Enter the PVP of the product (" + items.get(opt - 1).getPvp() + "): ");
        String description = Validations.getNoValidationLongStr("Enter the description of the product (" + items.get(opt - 1).getDescription() + "): ");
        String provider = Validations.getNoValidationLongStr("Enter the provider of the product (" + items.get(opt - 1).getProvider() + "): ");

        Product editedProduct = new Product(productName, cost, pvp, description, provider);

        editedProduct.editProduct(items.get(opt - 1).getId(), editedProduct);





    }

    private void displayCategoryMenu() {
        int optionCategory;
        do {
            System.out.println("-----  Category Menu  -----");
            System.out.println("1. See all categories");
            System.out.println("2. Find category");
            System.out.println("3. Add category");
            System.out.println("4. Delete category");
            System.out.println("5. Add product to category");
            System.out.println("6. Back");
            System.out.print("Choose an option (1-6): ");

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
                    addProductToCategory();
                    break;
                case 6:
                    System.out.println("Returning to the previous menu");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (optionCategory != 6);
    }


    private void displaySeeAllCategoriesMenu() {
        updateCategory();
        System.out.println("----- See All Categories -----");

        categoryList = category.getCategories();

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

        validations.waitForEnter();
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

        validations.waitForEnter();
    }

    private void displayAddCategoryMenu() {
        updateCategory();
        System.out.println("----- Add Category -----");
        String categoryName = Validations.validateStringInput("Enter the name of the category: ");
        String description = Validations.validateStringInput("Enter the description of the category: ");
        Category newCategory = new Category(categoryName, description);


        newCategory.saveCategory(newCategory);

        System.out.println("[+] Category '" + categoryName + "' added successfully.");
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
        categoryList.remove(validations.getIntOption("") - 1);

    }

    private void addProductToCategory() {
        int categoryOpt;
        List<Product> categoryItems;
        String categoryNameToFind = Validations.getNoValidationLongStr("Cateogry name: ");
        categoryItems = finder.findItem(Constans.CATEGORIES_FILE_NAME, categoryNameToFind.toLowerCase());

        int categoryIndex = 0;
        for (Product item : categoryItems) {
            System.out.println((categoryIndex + 1) + ") \n" + item.UIPrint());
            categoryIndex++;
        }
        do {
            categoryOpt = validations.getIntOption("option: ");
            if (categoryOpt < 1 || categoryOpt > categoryItems.size())
                System.out.println("Try again, invalid option");

        } while (categoryOpt < 1 || categoryOpt > categoryItems.size());

        int opt;
        List<Product> items;
        String productNameToFind = Validations.getNoValidationLongStr("Product name: ");
        items = finder.findItem(Constans.PRODUCTS_FILE_NAME, productNameToFind.toLowerCase());

        int index = 0;
        for (Product item : items) {
            System.out.println((index + 1) + ") \n" + item.UIPrint());
            index++;
        }
        do {
            opt = validations.getIntOption("option: ");
            if (opt < 1 || opt > items.size())
                System.out.println("Try again, invalid option");

        } while (opt < 1 || opt > items.size());

        category.addProductToCategory(categoryItems.get(categoryOpt - 1).getId(), items.get(opt - 1));
    }

    private void deleteProductToCategory() {
        System.out.println("----- Delete Product from Category -----");
        displaySeeAllCategoriesMenu();

        int categoryIndex = Validations.obtainOptionInventory() - 1;

        if (categoryIndex < 0 || categoryIndex >= categoryList.size()) {
            System.out.println("Invalid category index. Insert again.");
            return;
        }

        Category selectedCategory = categoryList.get(categoryIndex);
        displaySeeAllProductsMenu();

        int productIndex = Validations.obtainOptionInventory() - 1;

        if (productIndex < 0 || productIndex >= productList.size()) {
            System.out.println("Invalid product index. Returning to the previous menu.");
            return;
        }

        Product selectedProduct = productList.get(productIndex);

        selectedCategory.deleteProductToCategory(selectedProduct);

        fileHandlerCategory.saveCollection(categoryList, Constans.CATEGORIES_FILE_NAME);

        System.out.println("Product '" + selectedProduct.getName() + "' removed from category '" + selectedCategory.getName() + "' successfully.");
        System.out.println("Returning to the previous menu");
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

        validations.waitForEnter();
    }

    private void generateReport() {
        Stock stock = new Stock();
        System.out.println("Generatirng report...");
        stock.generateStockReport();
    }

    public void addStockToProduct() {
        Stock stock = new Stock();
        System.out.println("----- Add Stock to a Product -----");

        //Menu Select to grocery or storage
        int stockOpt;
        int id = finder.findProduct().getId();
        int units = 0;

        stock.getProductStockSummary(id);
        do {

            System.out.println("1. Add stock to grocery");
            System.out.println("2. Add stock to storage");
            stockOpt = validations.getIntOption("option: ");
            if (stockOpt == 1 || stockOpt == 2) {
                units = Validations.getIntPositiveOption("Enter the units to add: ");
            }
            switch (stockOpt) {
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
            if (stockOpt < 1 || stockOpt > 2)
                System.out.println("Try again, invalid option");
        } while (stockOpt < 1 || stockOpt > 2);
        System.out.println("Stock added successfully");
    }

    private void updateProduct() {
        productList = product.getProducts();
    }

    public void updateCategory() {
        categoryList = category.getCategories();
    }
}

