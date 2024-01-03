package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.utils.EmailHandler;
import ec.edu.espe.viveresgabysoftwarekit.utils.Validations;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

public class Market {


    private static final Validations validations = new Validations();

    private static final EmailHandler emailHandler;

    static {
        try {
            emailHandler = new EmailHandler();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Transaction transactionDefinition(ArrayList<ProductItem> kart, Transaction transaction, Customer customer) {
        int transactionOpt;
        do {
            System.out.println("----- Transaction Definition -----");
            System.out.println("1) Cash");
            System.out.println("2) Transaction");
            transactionOpt = validations.getIntOption("option: ");
            float fullAmount = 0;
            for (ProductItem item : kart) {
                fullAmount += (float) (item.getProduct().getPvp() * item.getUnits());
            }
            fullAmount += (float) (fullAmount * 0.12);
            System.out.println("Total Price: " + fullAmount);
            switch (transactionOpt) {
                case 1:
                    System.out.println("You selected Cash");
                    float ammount;
                    do {
                        ammount = Validations.validateFloatInput("Enter the ammount: ");
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
        return transaction;
    }

    public static void printSummary(Customer customer, Transaction transaction, ArrayList<ProductItem> kart, List<Discount> discountsToApply) throws MessagingException {
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
        for (Discount discount : discountsToApply) {
            dataToGeneratebill += discount.getName() + ": " + discount.getPercentage() + "%\n";
            subfinalPrice -= (subfinalPrice * (discount.getPercentage() / 100));
        }


        Tax taxes = new Tax(0, null, 0);
        float porcentualFactor = taxes.getAllTaxes().getLast().getPorcentFloat();



        dataToGeneratebill += "\n[Taxes] IVA 12%: " + (subfinalPrice * porcentualFactor) + "\n";
        dataToGeneratebill += "Final Price: " + (subfinalPrice * (porcentualFactor + 1)) + "\n";
        Bill bill = new Bill(customer, kart, discountsToApply);


        bill.saveCurrentBill();




        dataToGeneratebill += "\n-------------------------------------------------------";
        System.out.println(dataToGeneratebill);
        if (customer != null) {
            if (validations.getYNOption("Do you want to send the bill to the customer email? (y/n)")) {
                System.out.println("Sending the bill to the customer email...");
                System.out.println("Please wait a sec...");
                emailHandler.sendNewEmail(customer.getEmail(), "Viveres Gaby Bill", dataToGeneratebill);
            }
        }
        kart.clear();
    }

}
