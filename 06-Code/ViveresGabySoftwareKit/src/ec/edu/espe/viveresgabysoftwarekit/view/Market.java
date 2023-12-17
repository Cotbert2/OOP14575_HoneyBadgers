package ec.edu.espe.viveresgabysoftwarekit.view;

import java.util.*;

import ec.edu.espe.viveresgabysoftwarekit.model.*;
import ec.edu.espe.viveresgabysoftwarekit.model.Stock;
import ec.edu.espe.viveresgabysoftwarekit.utils.EmailHandler;
import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;
import ec.edu.espe.viveresgabysoftwarekit.utils.Search;
import ec.edu.espe.viveresgabysoftwarekit.utils.Validator;

import javax.mail.MessagingException;

public class Market {
    static Scanner in = new Scanner(System.in);
    static Validator validator = new Validator();

    static Search finder = new Search();

    static ArrayList<ProductItem> kart = new ArrayList<>();

    static EmailHandler emailHandler;

    static ConfirmDialog confirmDialog = new ConfirmDialog();

    static {
        try {
            emailHandler = new EmailHandler();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    static Customer customer;

    public Market() throws MessagingException {
    }

    public static int marketMainMenu() throws MessagingException {
        int option = 0;
        int sellOption = 0;
        System.out.println("----- Market Menu -----");
        System.out.println("1) New Sell");
        System.out.println("2) Back");
        do {
            option = validator.getIntOption();
            switch (option) {
                case 1:
                    System.out.println("You selected Sell");
                    sellOption = newSellMenu();
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

    public static int newSellMenu() throws MessagingException {
        int option = 0;
        do {
            System.out.println("----- New Sell Menu -----");
            System.out.println("1) Add Product");
            System.out.println("2) Delete Product");
            System.out.println("3) Next");
            System.out.println("4) Back");
            System.out.print("option: ");
            option = validator.getIntOption();
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
        return option;
    }

    public static int verificationMenu() {
        System.out.println("Are you sure you want to cancel (y/n): ");
        return validator.getYNOption();
    }

    public static void newSellProductAdd() {
        int opt = 0;
        List<Product> items = new ArrayList<>();
        do {
            System.out.print("name: ");
            String productNameToFind = in.nextLine();
            items = finder.findItem(Constans.PRODUCTS_FILE_NAME, productNameToFind.toLowerCase());
            if (items.isEmpty()) {
                System.out.println("Sorry, there is no product with that name");
                System.out.println("1) Search Again");
                System.out.println("2) Back");
                opt = validator.getIntOption();
                if(opt == 2)
                    return;
            } else {
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

                break;
            }
        } while (opt != 2);


        System.out.print("quantity: ");
        int quantity = validator.getIntOption();

        kart.add(new ProductItem(items.get(opt - 1), quantity));
    }

    public void newSellProductDeleteMenu() {
        int index = 0;
        for (ProductItem item : kart) {
            System.out.println((index + 1) + ") " + item.getProduct().getName() + "\t\t\t" + item.getUnits());
            System.out.println(item.getProduct().UIPrint());
            index++;
        }

        System.out.print("option: ");
        kart.remove(validator.getIntOption() - 1);
    }

    public static int newSellCustomer() throws MessagingException {
        System.out.println("----- New Sell-Customer -----");
        System.out.println("1) Data");
        System.out.println("2) Final Customer");
        System.out.println("3) Back");

        int option = 0;
        do {
            System.out.print("option: ");
            option = validator.getIntOption();
            switch (option) {
                case 1:
                    System.out.println("You selected Data");
                    int opt = 0;
                    List<Customer> items = new ArrayList<>();
                    do {
                        System.out.print("id(Cédula/ruc): ");
                        int id = validator.getIntOption();
                        String productNameToFind = Integer.toString(id);

                        items = finder.findCustomer(Constans.CUSTOMERS_FILE_NAME, productNameToFind.toLowerCase());
                        if (items.isEmpty()) {
                            System.out.println("Sorry, there is no user with that credentials");
                            System.out.println("1) Search Again");
                            System.out.println("2) Back");
                            opt = validator.getIntOption();
                        } else {
                            int index = 0;
                            for (Customer item : items) {
                                System.out.println((index + 1) + ") \n" + item.printUIInfor());
                                index++;
                            }
                            do {
                                opt = validator.getIntOption();
                                if (opt < 1 || opt > items.size())
                                    System.out.println("Try again, invalid option");

                            } while (opt < 1 || opt > items.size());

                            break;
                        }
                    } while (opt != 2);
                    customer = items.get(opt - 1);
                    printSummary();
                    break;
                case 2:
                    System.out.println("You selected Final Customer");
                    printSummary();
                    break;
                case 3:
                    System.out.println("You selected Back");
                    break;
                default:
                    System.out.println("Try again, invalid option");
            }
        } while (option < 1 || option > 4);
        return option;
    }

    public static void printSummary() throws MessagingException {
        String dataToGeneratebill = "";
        dataToGeneratebill += "-----------Summary-----------\n";
        dataToGeneratebill += "[Customer Information]: \n";
        if (customer != null)
            dataToGeneratebill += customer.printUIInfor();
        else
            dataToGeneratebill += "Final Customer\n";
        dataToGeneratebill += "[Product Information]: \n";
        dataToGeneratebill += "Product\t\t\tQuantity\t\t\tPrice\n";
        int index = 1;
        float subfinalPrice = 0f;
        for (ProductItem item : kart) {
            float price = (float) (item.getProduct().getPvp() * item.getUnits());
            dataToGeneratebill += index + ") " + item.getProduct().getName() + "\t\t\t" + item.getUnits() + "\t\t\t" + (price) + "\n";
            subfinalPrice += price;
            index++;
        }
        dataToGeneratebill += "\n-------------------------------------------------------\n";
        dataToGeneratebill += "Subtotal: " + subfinalPrice;
        dataToGeneratebill += "\n[Taxes] IVA 12%: " + (subfinalPrice * 0.12) + "\n";
        dataToGeneratebill += "Final Price: " + (subfinalPrice * 1.12) + "\n";
        Date date = new Date();
        Bill bill = new Bill(0, customer, kart, date);

        FileHandler<Bill> fileHandler = new FileHandler<>();
        List<Bill> bills = new ArrayList<>();
        bills.add(bill);
        fileHandler.saveJSONFile(bills, Constans.BILLS_FILE_NAME);
        dataToGeneratebill += "\n-------------------------------------------------------";
        System.out.println(dataToGeneratebill);
        if(customer != null){
            System.out.println("Sending the bill to the customer email...");
            System.out.println("Please wait a sec...");
            emailHandler.sendNewEmail(customer.getEmail(), "Viveres Gaby Bill", dataToGeneratebill);
        }
        kart.clear();
    }

    public String getSring() {
        return in.nextLine();
    }

    public static String findProduct(String productNameToFind) {
        Stock stock = new Stock();
        return stock.findProduct(productNameToFind);
    }

    public static void deleteKartItem() {
        System.out.println("----- Delete Product Menu -----");
        int index = 1;
        for (ProductItem item : kart) {
            System.out.println(index + ") " + item.getProduct().getName() + "\t\t\t" + item.getUnits());
            index++;
        }
        System.out.println(index + ") Back");
        System.out.print("Select an option: ");
        int option = validator.getIntOption();
        if (option < 1 || option > kart.size())
            System.out.println("Try again, invalid option");
        else
            kart.remove(option - 1);
    }
}
