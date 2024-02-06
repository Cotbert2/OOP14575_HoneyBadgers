package ec.edu.espe.viveresgabysoftwarekit.utils;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.model.Category;
import ec.edu.espe.viveresgabysoftwarekit.model.Customer;
import ec.edu.espe.viveresgabysoftwarekit.model.Product;

import java.util.ArrayList;
import java.util.List;


/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class Search {

    DbManager<Product> fileHandler = new DbManager<>();
    DbManager<Customer> fileHandlerCustomer = new DbManager<>();

    DbManager<Category> fileHandlerCategory = new DbManager<>();

    Validations validations = new Validations();

    public List<Product> findItem(String filepath, String name){
        List<Product> items = new ArrayList<>();
        List<Product> compatibleItem = new ArrayList<>();

        items = fileHandler.readJSONListGeneric(filepath, Product.class);
        for (Product item : items) {
            if(item.getName().toLowerCase().contains(name))
                compatibleItem.add(item);
        }

        return compatibleItem;

    }

    public int findItemPosition(String filepath, int id){
        int index = 0;
        int indexToEdit = 0;
        List<Product> items = new ArrayList<>();
        List<Product> compatibleItem = new ArrayList<>();

        items = fileHandler.readJSONListGeneric(filepath, Product.class);
        for (Product item : items) {
            if(item.getId() == id)
                indexToEdit = index;
            index++;
        }
        return indexToEdit;
    }

    public List<Category> findCategory(String filepath, String name){
        List<Category> items = new ArrayList<>();
        List<Category> compatibleItem = new ArrayList<>();

        items = fileHandlerCategory.readJSONListGeneric(filepath, Category.class);
        for (Category item : items) {
            if(item.getName().contains(name))
                compatibleItem.add(item);
        }

        return compatibleItem;

    }

    public List<Customer> findCustomer(String filepath, String name){
        List<Customer> items = new ArrayList<>();
        List<Customer> compatibleItem = new ArrayList<>();

        items = fileHandlerCustomer.readJSONListGeneric(filepath, Customer.class);

        for (Customer customer : items) {
            if( Integer.toString(customer.getId()).contains(name))
                compatibleItem.add(customer);
        }

        return compatibleItem;

    }

    public ArrayList<Category> splitCategory(ArrayList<Category> categories, int id){
        int index = 0;
        int indexToSplit = 0;
        for(Category category : categories){
            if(category.getId() == id){
                indexToSplit = index;
            }
            index++;
        }
        categories.remove(indexToSplit);
        return categories;

    }

    public Product findProduct() {
        int opt;
        List<Product> items;
        do {
            String productNameToFind = Validations.getNoValidationLongStr("name: ");
            items = findItem(Constans.PRODUCTS_FILE_NAME, productNameToFind.toLowerCase());
            if (items.isEmpty()) {
                System.out.println("Sorry, there is no product with that name");
                System.out.println("1) Search Again");
                System.out.println("2) Back");
                opt = validations.getIntOption("option: ");
                if (opt == 2)
                    return null;
            } else {
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
                return items.get(opt - 1);


            }
        } while (opt != 2);
        return items.get(opt - 1);
    }
}
