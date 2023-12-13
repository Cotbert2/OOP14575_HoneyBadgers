package ec.edu.espe.viveresgabysoftwarekit.model;
import com.google.gson.Gson;
import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Stefany Díaz,Eduardo Garcia, Mateo García, Alex Cuzco, honeyBADGERS, DCCO-ESPE
 */
public class MenuFinancer{
    private static Scanner scanner = new Scanner(System.in);
    private int option;
    private ArrayList<Bill> bills = new ArrayList<>();
    private Financer financer;
    private List<Bill> existingBills;
    FileHandler<Bill> fileHandler = new FileHandler<>();
    
    
    public MenuFinancer(){
        
    }
    
    public void handMenuFinancer(){
        do{
            System.out.println("----Menu Financer----");
            System.out.println("1. Bills");
            System.out.println("2. Client");
            System.out.println("3. Financer Status");
            System.out.println("4. Update Taxes");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");
            
        option = getOption();

            switch(option){
                 case 1:
                    System.out.println("You selected Bills");
                    doBillsAction();
                    break;
                case 2:
                    System.out.println("You selected Client");
                    doClientAction();
                    break;
                case 3:
                    System.out.println("You selected Financer Status");
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
        }while(option !=5);

    }

    private int getOption(){
           while(true){
            try {
                 int input = Integer.parseInt(scanner.nextLine());
                if (input >= 1 && input <= 9) {
                    return input;
                } else {
                    System.out.print("Invalid option, try again: ");
                }
            } catch (NumberFormatException e){
                System.out.print("Invalid entry, try again: ");     
            }
        
        }
    
    }

    private void doBillsAction(){
        int subOption;
        do{
            System.out.println("---Financer - Bill Menu---");
            System.out.println("1. Create Bill");
            System.out.println("2. History Bills");
            System.out.println("3. Delete Bill ");
            System.out.println("4. Back");
            
        subOption = getOption();
        
        switch(subOption){
            case 1:
                System.out.println("You selected Create Bill");
                createBill();
                break;
            case 2:
                System.out.println("You selected History Bills");
                showBills();
                break;
            case 3:
                System.out.println("You selected Delete Bill");
                deleteBill();
                break;
            case 4:
                System.out.println("Back to Menu Financer");
                break;
            default:
                System.out.println("Try again, invalid option");
        
        }
      } while(subOption !=4);
}
    
    // En la clase MenuFinancer

    private void createBill() {
        System.out.print("Enter client name: ");
        String clientName = scanner.nextLine();

        System.out.print("Enter client ID: ");
        String clientId = scanner.nextLine();

        System.out.print("Enter number of products: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Product " + (i + 1) + ":");
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();

            float productCost;
            while (true) {
                System.out.print("Enter product cost: ");
                if (scanner.hasNextFloat()) {
                    productCost = scanner.nextFloat();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid floating-point number.");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();

            Product newProduct = new Product(clientName, i, i, clientId, productName, clientId);
            products.add(newProduct);
        }

        System.out.print("Enter total cost: ");
        float totalCost = scanner.nextFloat();
        scanner.nextLine();
        Date purchaseDay = null;

        Bill newBill = new Bill(option, clientName, clientId, numProducts, totalCost, purchaseDay, products);
        bills.add(newBill);
        
        saveBill(newBill);
        System.out.println("Bill created successfully!");
}

    private void saveBill(Bill bill) {
    List<Bill> existingBills = fileHandler.readJSONList("C:\\Users\\YALEDAPC\\Stefy Díaz\\POO Stefy Díaz\\PROYECTO\\OOP14575_HoneyBadgers\\06-Code\\ViveresGabySoftwareKit\\bills.json");

    existingBills.add(bill);

    try (FileWriter writer = new FileWriter("C:\\Users\\YALEDAPC\\Stefy Díaz\\POO Stefy Díaz\\PROYECTO\\OOP14575_HoneyBadgers\\06-Code\\ViveresGabySoftwareKit\\bills.json")) {
        Gson gson = new Gson();
        writer.write(gson.toJson(existingBills));
        System.out.println("Bill saved successfully!");
    } catch (IOException e) {
        System.err.println("[-] Something went wrong: " + e.getMessage());
    }
}



    private void showBills() {
    System.out.println("---- History Bills ----");
    System.out.println("ID\tClient\t\tProducts\tTotal Cost");

    // Mostrar las facturas en memoria
    for (Bill bill : this.bills) {
        System.out.print(
                bill.getId() + "\t" +
                        bill.getClientName() + "\t\t"
        );

        for (Product product : bill.getProducts()) {
            System.out.print(product.getName() + "(" + product.getCost() + "), ");
        }

        System.out.println("\t\t" + bill.getTotalCost());
    }

    this.existingBills = fileHandler.readJSONList("path_to_bills_file.json");
    for (Bill bill : this.existingBills) {
        System.out.print(
                bill.getId() + "\t" +
                        bill.getClientName() + "\t\t"
        );

        for (Product product : bill.getProducts()) {
            System.out.print(product.getName() + "(" + product.getCost() + "), ");
        }

        System.out.println("\t\t" + bill.getTotalCost());
    }
}




    private void deleteBill() {
    System.out.print("Enter the ID of the bill to delete: ");
    int billIdToDelete = scanner.nextInt();
    scanner.nextLine();

    Iterator<Bill> iterator = this.bills.iterator();
    boolean found = false;

    while (iterator.hasNext()) {
        Bill bill = iterator.next();
        if (bill.getId() == billIdToDelete) {
            iterator.remove();
            found = true;
            System.out.println("Bill deleted successfully!");
            break;
        }
    }

    if (!found) {
        System.out.println("Bill with ID " + billIdToDelete + " not found.");
    }
}


    private void doClientAction(){
        int subOption;
        do{
            System.out.println("---Financer - Client Menu---");
            System.out.println("1. Create Client");
            System.out.println("2. See all Clients ");
            System.out.println("3. Back");
            
        subOption = getOption();
        
        switch(subOption){
            case 1:
                System.out.println("You selected Create Client");
                createCustomer();
                break;
            case 2:
                System.out.println("You selected See all Clients");
                showCustomers();
                break;
            case 3:
                System.out.println("Back to Menu Financer");
                break;
            default:
                System.out.println("Try again, invalid option");
        
        }
      } while(subOption !=3);
}
    
    private void createCustomer() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();

        Customer newCustomer = new Customer(id, name, email, address, phone);

    
        financer.addCustomer(newCustomer);

        System.out.println("Customer created successfully!");
}

    private void showCustomers() {
        System.out.println("---- All Customers ----");
        System.out.println("ID\tName\tEmail\tAddress\tPhone");

        for (Customer customer : financer.getCustomers()) {
            System.out.println(
                customer.getId() + "\t" +
                customer.getFullname() + "\t" +
                customer.getEmail() + "\t" +
                customer.getAddress() + "\t" +
                customer.getPhone()
        );
    }
}



    private void doFinancerStatusAction(){
        System.out.println("---Financer Status Menu---");
        System.out.println("0. Go Back");

        int subOption = getOption();

        if (subOption == 0) {
            System.out.println("Going back to Financer Menu...");
        } else {
            System.out.println("Invalid option, try again");
        }   
    }
      


    private void doUpdateTaxesAction(){
        System.out.println("---Financer - Update Taxes Menu---");
        System.out.println("0. Go Back");

        int subOption = getOption();

        if (subOption == 0) {
            System.out.println("Going back to Financer Menu...");
        } else {
            System.out.println("Invalid option, try again");
    }
}    
    }


