package ec.edu.espe.viveresgabysoftwarekit.view.menus;

import java.util.*;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.model.*;
import ec.edu.espe.viveresgabysoftwarekit.utils.*;

import javax.mail.MessagingException;

public class Market {
    static Scanner in = new Scanner(System.in);
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

    public Market() throws MessagingException {
    }

    public static int marketMainMenu() throws MessagingException {
        int option = 0;
        System.out.println("----- Market Menu -----");
        System.out.println("1) New Sell");
        System.out.println("2) Back");
        do {
            System.out.print("option: ");
            option = validations.getIntOption();
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

    public static int newSellMenu() throws MessagingException {
        int option = 0;
        do {
            System.out.println("----- New Sell Menu -----");
            System.out.println("1) Add Product to the kart");
            System.out.println("2) Delete Product");
            System.out.println("3) Next");
            System.out.println("4) Back");
            System.out.print("option: ");
            option = validations.getIntOption();
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
                System.out.print("option: ");
                opt = validations.getIntOption();
                if (opt == 2)
                    return;
            } else {
                int index = 0;
                for (Product item : items) {
                    System.out.println((index + 1) + ") \n" + item.UIPrint());
                    index++;
                }
                do {
                    System.out.print("option: ");
                    opt = validations.getIntOption();
                    if (opt < 1 || opt > items.size())
                        System.out.println("Try again, invalid option");

                } while (opt < 1 || opt > items.size());

                break;
            }
        } while (opt != 2);


        System.out.print("quantity: ");
        int quantity = validations.getIntPositiveOption();

        kart.add(new ProductItem(items.get(opt - 1), quantity));
    }

    public static int newSellCustomer() throws MessagingException {
        System.out.println("----- New Sell-Customer -----");
        System.out.println("1) Data");
        System.out.println("2) Final Customer");
        System.out.println("3) Back");

        int option = 0;
        do {
            System.out.print("option: ");
            option = validations.getIntOption();
            switch (option) {
                case 1:
                    System.out.println("You selected Data");
                    int opt;
                    List<Customer> items;
                    do {
                        System.out.print("id(Cédula/ruc): ");
                        int id = validations.getIntOption();
                        String productNameToFind = Integer.toString(id);
                        items = finder.findCustomer(Constans.CUSTOMERS_FILE_NAME, productNameToFind.toLowerCase());
                        if (items.isEmpty()) {
                            System.out.println("Sorry, there is no user with that credentials");
                            System.out.println("1) Search Again");
                            System.out.println("2) Back");
                            opt = validations.getIntOption();
                        } else {
                            int index = 0;
                            for (Customer item : items) {
                                System.out.println((index + 1) + ") \n" + item.printUIInfor());
                                index++;
                            }
                            System.out.print("option: ");
                            do {
                                opt = validations.getIntOption();
                                if (opt < 1 || opt > items.size())
                                    System.out.println("Try again, invalid option");

                            } while (opt < 1 || opt > items.size());
                            break;
                        }
                    } while (opt != 2);
                    customer = items.get(opt - 1);
                    transactionDefinition();
                    discountsInterface();
                    printSummary();
                    break;
                case 2:
                    System.out.println("You selected Final Customer");
                    transactionDefinition();
                    discountsInterface();
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

    public static void transactionDefinition() throws MessagingException {
        int transactionOpt = 0;
        do {
            System.out.println("----- Transaction Definition -----");
            System.out.println("1) Cash");
            System.out.println("2) Transaction");
            System.out.print("option: ");
            transactionOpt = validations.getIntOption();
            float fullAmount = 0;
            for (ProductItem item : kart) {
                fullAmount += item.getProduct().getPvp() * item.getUnits();
            }
            fullAmount += (fullAmount * 0.12);
            System.out.println("Total Price: " + fullAmount);
            switch (transactionOpt) {
                case 1:
                    System.out.println("You selected Cash");
                    float ammount;
                    do {
                        ammount = validations.validateFloatInput("Enter the ammount: ");
                        if (ammount < fullAmount)
                            System.out.println("You try to enter an amount less than the total price, try again");
                    } while (ammount < fullAmount);
                    transaction = new Transaction(true, ammount, customer);
                    transaction.saveTransaction();
                    System.out.println("YOUR CHANGE: " + transaction.computerChange(fullAmount));
                    break;
                case 2:
                    System.out.println("You selected Transaction");
                    transaction = new Transaction(false, fullAmount, customer);
                    transaction.saveTransaction();

                    break;
                default:
                    System.out.println("Try again, invalid option");
            }
        } while (transactionOpt < 1 || transactionOpt > 3);
    }


    public static void printSummary() throws MessagingException {
        String dataToGeneratebill = "";
        dataToGeneratebill += "-----------Summary-----------\n";
        dataToGeneratebill += "[Customer Information]: \n";
        if (customer != null)
            dataToGeneratebill += customer.printUIInfor();
        else
            dataToGeneratebill += "Final Customer\n";

        dataToGeneratebill += transaction.seeTransactionDetails();
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
        dataToGeneratebill += "\n[Discounts]: \n";
        for (Discount discount : discountsToAplly) {
            dataToGeneratebill += discount.getName() + ": " + discount.getPercentage() + "%\n";
            subfinalPrice -= (subfinalPrice * (discount.getPercentage() / 100));
        }


        FileHandler<Tax> fileHandlerTaxes = new FileHandler<>();
        float porcentualFactor = fileHandlerTaxes.readJSONListTax(Constans.TAXES_FILE_NAME).getLast().getPorcentFloat();


        dataToGeneratebill += "\n[Taxes] IVA 12%: " + (subfinalPrice * porcentualFactor) + "\n";
        dataToGeneratebill += "Final Price: " + (subfinalPrice * (porcentualFactor + 1)) + "\n";
        Date date = new Date();
        Bill bill = new Bill(customer, kart, date, discountsToAplly);

        FileHandler<Bill> fileHandler = new FileHandler<>();
        List<Bill> bills = fileHandler.readJSONListBills(Constans.BILLS_FILE_NAME);
        bills.add(bill);
        fileHandler.saveJSONFile(bills, Constans.BILLS_FILE_NAME);
        dataToGeneratebill += "\n-------------------------------------------------------";
        System.out.println(dataToGeneratebill);
        if (customer != null) {
            System.out.println("Do you want to send the bill to the customer email? (y/n)");
            if (validations.getYNOption()) {
                System.out.println("Sending the bill to the customer email...");
                System.out.println("Please wait a sec...");
                emailHandler.sendNewEmail(customer.getEmail(), "Viveres Gaby Bill", dataToGeneratebill);
            }
        }
        kart.clear();
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
        int option = validations.getIntOption();
        if (option < 1 || option > kart.size())
            System.out.println("Try again, invalid option");
        else
            kart.remove(option - 1);
    }

    public static void discountsInterface() {
        Discount discount = new Discount(0, null, 0, null, null);
        List<Discount> discounts = discount.getAllDiscounts();

        System.out.print("Do you want to apply a discount? (y/n)");
        if (validations.getYNOption()) {
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
                System.out.print("Select an option: ");
                option = validations.getIntOption();
                if (option < 1 || option > discounts.size())
                    System.out.println("Try again, invalid option");
                else
                    discountsToAplly.add(discounts.get(option - 1));
            } while (option != 0);
        }
    }

}