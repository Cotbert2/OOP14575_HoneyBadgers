package ec.edu.espe.viveresgabysoftwarekit.view.menus;

import ec.edu.espe.viveresgabysoftwarekit.model.*;
import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ec.edu.espe.viveresgabysoftwarekit.utils.*;

/**
 * @author Stefany Díaz,Eduardo Garcia, Mateo García, Alex Cuzco, honeyBADGERS, DCCO-ESPE
 */
public class FinancerMenu {
    private static Scanner scanner = new Scanner(System.in);
    private int option;
    private ArrayList<Bill> bills = new ArrayList<>();
    private Financer financer;
    private List<Bill> existingBills;
    FileHandler<Bill> fileHandlerBills = new FileHandler<>();
    FileHandler<Customer> fileHandlerCustomers = new FileHandler<>();
    FileHandler<Tax> fileHandlerTaxes = new FileHandler<>();


    Validations validations = new Validations();
    List<Bill> allBills;
    List<Customer> customers;

    public FinancerMenu() {

    }

    public void handMenuFinancer() {
        do {
            System.out.println("----Menu Financer----");
            System.out.println("1. Bills");
            System.out.println("2. Customers");
            System.out.println("3. Financer Report");
            System.out.println("4. Update Taxes");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");

            option = getOption();

            switch (option) {
                case 1:
                    System.out.println("You selected Bills");
                    doBillsAction();
                    break;
                case 2:
                    System.out.println("You selected Customer");
                    doCustomerAction();
                    break;
                case 3:
                    System.out.println("You selected Financer Report");
                    doFinancerStatusAction();
                    break;
                case 4:
                    System.out.println("You selected Update Taxes");
                    doUpdateTaxesAction();
                    break;
                case 5:
                    System.out.println("Leaving to the principal menu...");
                    break;
                default:
                    System.out.println("Try again, invalid option");
            }
        } while (option != 5);

    }

    private int getOption() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= 1 && input <= 9) {
                    return input;
                } else {
                    System.out.print("Invalid option, try again: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid entry, try again: ");
            }

        }

    }

    private void doBillsAction() {
        int subOption;
        do {
            System.out.println("---Financer - Bill Menu---");
            System.out.println("1. History Bills");
            System.out.println("2. Back");

            subOption = getOption();

            switch (subOption) {
                case 1:
                    System.out.println("You selected History Bills");
                    showBills();
                    break;
                case 2:
                    System.out.println("Back to Menu Financer");
                    break;
                default:
                    System.out.println("Try again, invalid option");

            }
        } while (subOption != 2);
    }


    private void showBills() {
        updateBillsInfo();
        String singularBillInformation = "";
        if (allBills.isEmpty()) {
            System.out.println("No bills available.");
        } else {
            System.out.println("---- All Bills ----");
            System.out.println("ID\tCustomer Id\tCustomer Name\tNum Products\tTotal Cost\tPurchase Day");

            for (Bill bill : allBills) {

                singularBillInformation = bill.getId() + "\t";

                if (bill.getCustomer() == null) {
                    singularBillInformation += "xxxxxxxxxxxxxxx" + "\t" + "xxxxxxxxxxxxxxx" + "\t";
                } else {
                    singularBillInformation += bill.getCustomer().getId() + "\t" + bill.getCustomer().getFullname() + "\t";
                }

                singularBillInformation +=

                        bill.getProducts().size() + "\t" +
                                "" + "\t" +
                                bill.getPurchaseDay();
                System.out.println(singularBillInformation);
            }
        }
    }


    private void doCustomerAction() {
        int subOption;
        do {
            System.out.println("---Financer/ Customer Menu---");
            System.out.println("1. Create Customer");
            System.out.println("2. See all Customer ");
            System.out.println("3. Back");
            System.out.print("option: ");
            subOption = getOption();

            switch (subOption) {
                case 1:
                    System.out.println("You selected Create Customer");
                    createCustomer();
                    break;
                case 2:
                    System.out.println("You selected See all Customer");
                    showCustomers();
                    break;
                case 3:
                    System.out.println("Back to Menu Financer");
                    break;
                default:
                    System.out.println("Try again, invalid option");

            }
        } while (subOption != 3);

    }


    private void createCustomer() {
        updateCustomersInfor();
        int id = 0;
        do {
            id = validations.validateIntInput("Enter customer ID: ");
            if (!verifyUnicCustomerId(id))
                System.out.println("Customer ID already exists, try again");
        } while (!verifyUnicCustomerId(id));
        String name = validations.noValidationStr("Enter customer name: ");
        String email = validations.validateEmail("Enter customer email: ");
        String address = validations.noValidationStr("Enter customer address: ");
        String phone = validations.validatePhone("Enter customer phone: ");

        Customer newCustomer = new Customer(id, name, email, address, phone);

        customers.add(newCustomer);
        fileHandlerCustomers.saveJSONFile(customers, Constans.CUSTOMERS_FILE_NAME);

        System.out.println("Customer created successfully!");
    }

    private void showCustomers() {
        updateCustomersInfor();

        System.out.println("---- All Customers ----");

        System.out.println("ID\tName\tEmail\tAddress\tPhone");

        for (Customer customer : customers) {
            System.out.println(
                    customer.getId() + "\t" +
                            customer.getFullname() + "\t" +
                            customer.getEmail() + "\t" +
                            customer.getAddress() + "\t" +
                            customer.getPhone()
            );
        }
    }


    private void doFinancerStatusAction() {
        System.out.println("---Financer  Menu---");
        FinancerReport financerReport = new FinancerReport();
        financerReport.generateFinancerReport();
        System.out.println("[+] Financer Report Saved at ./output");
        System.out.println("0. Go Back");

        int subOption = getOption();

        if (subOption == 0) {
            System.out.println("Going back to Financer Menu...");
        } else {
            System.out.println("Invalid option, try again");
        }
    }


    private void doUpdateTaxesAction() {
        System.out.println("---Financer - Update Iva Menu---");
        Scrapper scrapper = new Scrapper();
        float ivaUpdate = scrapper.updateIva();
        List<Tax> taxes =  fileHandlerTaxes.readJSONListTax(Constans.TAXES_FILE_NAME);

        for(Tax tax: taxes){
            if(tax.getId() == 1)
                tax.setPorcent((int) ivaUpdate);
        }

        System.out.println("0. Go Back");
        System.out.println("option: ");
        int subOption = getOption();

        if (subOption == 0) {
            System.out.println("Going back to Financer Menu...");
        } else {
            System.out.println("Invalid option, try again");
        }
    }

    public boolean verifyUnicCustomerId(int idToVerify) {
        updateCustomersInfor();
        for (Customer customer : customers) {
            if (customer.getId() == idToVerify) {
                return false;
            }
        }
        return true;
    }

    public void updateBillsInfo() {
        allBills = fileHandlerBills.readJSONListBills(Constans.BILLS_FILE_NAME);
    }

    public void updateCustomersInfor() {
        customers = fileHandlerCustomers.readJSONListCustomers(Constans.CUSTOMERS_FILE_NAME);
    }
}