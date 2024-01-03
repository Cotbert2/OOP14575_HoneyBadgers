package ec.edu.espe.viveresgabysoftwarekit.view.menus;

import java.util.*;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.model.*;
import ec.edu.espe.viveresgabysoftwarekit.utils.*;

import javax.mail.MessagingException;

public class MarketMenu {

    static Validations validations = new Validations();

    static Search finder = new Search();

    static ArrayList<ProductItem> kart = new ArrayList<>();

    static EmailHandler emailHandler;

    static ConfirmDialog confirmDialog = new ConfirmDialog();

    static Transaction transaction;

    static {
        try {
            emailHandler = new EmailHandler();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    static Customer customer;

    static List<Discount> discountsToAplly = new ArrayList<>();

    public MarketMenu() throws MessagingException {
    }

    public static int marketMainMenu() throws MessagingException {
        int option;
        System.out.println("----- MarketMenu Menu -----");
        System.out.println("1) New Sell");
        System.out.println("2) Back");
        do {

            option = validations.getIntOption("option: ");
            switch (option) {
                case 1:
                    System.out.println("You selected Sell");
                    newSellMenu();
                    break;
                case 2:
                    System.out.println("Leaving to the principal menu...");
                    break;
                default:
                    System.out.println("Try again, invalid option");
            }
        } while (option < 1 || option > 2);
        return option;

    }

    public static void newSellMenu() throws MessagingException {
        int option;
        do {
            System.out.println("----- New Sell Menu -----");
            System.out.println("1) Add Product to the kart");
            System.out.println("2) Delete Product from the kart");
            System.out.println("3) Next");
            System.out.println("4) Back");
            option = validations.getIntOption("option: ");
            switch (option) {

                case 1:
                    System.out.println("You selected Add Product");
                    newSellProductAdd();
                    break;

                case 2:
                    System.out.println("You selected Delete Product");
                    if (kart.isEmpty())
                        System.out.println("You must add at least one product");
                    else
                        deleteKartItem();

                    break;

                case 3:
                    System.out.println("You selected Next");
                    if (kart.isEmpty())
                        System.out.println("You must add at least one product");
                    else
                        newSellCustomer();

                    break;

                case 4:
                    System.out.println("You selected Back");
                    if (!kart.isEmpty())
                        confirmDialog.confirmDialog("Are you sure you want to cancel the sell?");
                    else
                        System.out.println("Quiting to the principal menu...");
                    break;

                default:
                    System.out.println("Try again, invalid option");
            }
        } while (option != 4);
    }

    public static void newSellProductAdd() {
        int opt;
        List<Product> items;
        do {
            String productNameToFind = Validations.getNoValidationStr("name: ");
            items = finder.findItem(Constans.PRODUCTS_FILE_NAME, productNameToFind.toLowerCase());
            if (items.isEmpty()) {
                System.out.println("Sorry, there is no product with that name");
                System.out.println("1) Search Again");
                System.out.println("2) Back");
                opt = validations.getIntOption("option: ");
                if (opt == 2)
                    return;
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

                break;
            }
        } while (opt != 2);

        Stock stock = new Stock();
        int totalUnits = stock.getStockUnits(items.get(opt - 1).getId());
        int groceryUnits = stock.getGroceryUnits(items.get(opt - 1).getId());
        int quantity;

        if (totalUnits == 0) {
            System.out.println("Sorry, there is no stock of that product");
            return;
        } else {
            System.out.println("There are " + totalUnits + " units in stock");
            do {
                quantity = Validations.getIntPositiveOption("quantity: ");
                if (quantity > totalUnits)
                    System.out.println("The quantity is greater than the stock, try again");
            } while (quantity > totalUnits);

            if (quantity > groceryUnits)
                System.out.print("The quantity is greater than the grocery stock, the product will be taken from the storage");

            stock.stockHandlerBySell(items.get(opt - 1).getId(), quantity);
        }

        kart.add(new ProductItem(items.get(opt - 1), quantity));
    }

    public static void newSellCustomer() throws MessagingException {
        System.out.println("----- New Sell-Customer -----");
        System.out.println("1) Data");
        System.out.println("2) Final Customer");
        System.out.println("3) Back");

        int option;
        do {
            option = validations.getIntOption("option: ");
            switch (option) {
                case 1:
                    System.out.println("You selected Data");
                    int opt;
                    List<Customer> items;
                    do {
                        int id = validations.getIntOption("id(Cédula/ruc): ");
                        String productNameToFind = Integer.toString(id);
                        items = finder.findCustomer(Constans.CUSTOMERS_FILE_NAME, productNameToFind.toLowerCase());
                        if (items.isEmpty()) {
                            System.out.println("Sorry, there is no user with that credentials");
                            System.out.println("1) Search Again");
                            System.out.println("2) Back");
                            opt = validations.getIntOption("option: ");
                            if(opt  == 2)
                                return;
                        } else {
                            int index = 0;
                            for (Customer item : items) {
                                System.out.println((index + 1) + ") \n" + item.printUIInfor());
                                index++;
                            }
                            do {
                                opt = validations.getIntOption("option: ");
                                if (opt < 1 || opt > items.size())
                                    System.out.println("Try again, invalid option");

                            } while (opt < 1 || opt > items.size());
                            break;
                        }
                    } while (opt != 2);
                    customer = items.get(opt - 1);
                    transaction = Market.transactionDefinition(kart, transaction, customer);
                    discountsInterface();
                    Market.printSummary(customer, transaction, kart, discountsToAplly);
                    kart.clear();
                    break;
                case 2:
                    System.out.println("You selected Final Customer");
                    transaction = Market.transactionDefinition(kart, transaction, customer);
                    discountsInterface();
                    Market.printSummary(customer, transaction, kart, discountsToAplly);
                    kart.clear();
                    break;
                case 3:
                    System.out.println("You selected Back");
                    break;
                default:
                    System.out.println("Try again, invalid option");
            }
        } while (option < 1 || option > 4);
    }

    public static void deleteKartItem() {
        System.out.println("----- Delete Product Menu -----");
        int index = 1;
        for (ProductItem item : kart) {
            System.out.println(index + ") " + item.getProduct().getName() + "\t\t\t" + item.getUnits());
            index++;
        }
        System.out.println(index + ") Back");
        int option = validations.getIntOption("Select an option: ");
        if (option < 1 || option > kart.size())
            System.out.println("Try again, invalid option");
        else
            kart.remove(option - 1);
    }

    public static void discountsInterface() {
        Discount discount = new Discount(0, null, 0, null, null);
        List<Discount> discounts = discount.getAllDiscounts();

        if (validations.getYNOption("Do you want to apply a discount? (y/n)")) {
            int option = -1;
            int index;
            do {
                index = 0;
                System.out.println("0) Back");
                for (Discount discountItem : discounts) {
                    System.out.println((index + 1) + ")");
                    discountItem.UIPrint();
                    index++;
                }
                option = validations.getIntOption("Select an option: ");
                if (option < 1 || option > discounts.size())
                    System.out.println("Try again, invalid option");
                else
                    discountsToAplly.add(discounts.get(option - 1));
            } while (option != 0);
        }
    }

}

