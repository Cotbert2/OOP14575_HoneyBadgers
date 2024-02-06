package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.utils.EmailHandler;
import ec.edu.espe.viveresgabysoftwarekit.utils.DbManager;
import ec.edu.espe.viveresgabysoftwarekit.utils.Validations;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class Bill {

    private int id;

    private Customer customer;
    private List<ProductItem> products;
    private Date purchaseDay;
    private List<Discount> discounts;

    private float totalPrice;
    private float totalEarnings;


    public Bill(Customer customer, List<ProductItem> products, List<Discount> discounts) {
        DbManager<Bill> fileHandler = new DbManager<>();
        this.id = fileHandler.readJSONListGeneric(Constans.BILLS_FILE_NAME, Bill.class).getLast().id + 1;
        this.customer = customer;
        this.products = products;
        this.purchaseDay = new Date();
        this.discounts = discounts;
        totalPrice = 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ProductItem> getProducts() {
        return products;
    }

    public void setProducts(List<ProductItem> products) {
        this.products = products;
    }

    public Date getPurchaseDay() {
        return purchaseDay;
    }

    public void setPurchaseDay(Date purchaseDay) {
        this.purchaseDay = purchaseDay;
    }

    public String UIPrint() {
        return (
                "*********************************" + "\n" +
                        "\t\t" + customer.getFullname() + "\n" +
                        "*********************************" + "\n" +
                        "ID: " + id + "\n" +
                        "Purchase Day: " + purchaseDay + "\n" +
                        "Products: " + products.size() + "\n"
        );
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(float totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public void saveCurrentBill() {
        DbManager<Bill> fileHandler = new DbManager<>();
        List<Bill> bills = fileHandler.readJSONListGeneric(Constans.BILLS_FILE_NAME, Bill.class);
        bills.add(this);
        fileHandler.saveCollection(bills, Constans.BILLS_FILE_NAME);
    }

    public void doBill(Transaction transaction, List<ProductItem> kart, List<Discount> discountsToAplly, Customer customer, Validations validations) throws MessagingException {
        EmailHandler emailHandler = new EmailHandler();
        String dataToGeneratebill = "";
        dataToGeneratebill += "-----------Summary-----------\n";
        dataToGeneratebill += "[Customer Information]: \n";
        //Customer as parammeter
        if (customer != null)
            dataToGeneratebill += customer.printUIInfor();
        else
            dataToGeneratebill += "Final Customer\n";

        dataToGeneratebill += transaction.seeTransactionDetails();
        dataToGeneratebill += "[Product Information]: \n";
        dataToGeneratebill += "Product\t\t\tQuantity\t\t\tPrice\n";
        int index = 1;
        float subfinalPrice = 0f;
        //Kart as parammeter
        for (ProductItem item : kart) {
            float price = (float) (item.getProduct().getPvp() * item.getUnits());
            dataToGeneratebill += index + ") " + item.getProduct().getName() + "\t\t\t" + item.getUnits() + "\t\t\t" + (price) + "\n";
            subfinalPrice += price;
            index++;
        }
        dataToGeneratebill += "\n-------------------------------------------------------\n";
        dataToGeneratebill += "Subtotal: " + subfinalPrice;
        dataToGeneratebill += "\n[Discounts]: \n";
        //Discounts as parammeter
        for (Discount discount : discountsToAplly) {
            dataToGeneratebill += discount.getName() + ": " + discount.getPercentage() + "%\n";
            subfinalPrice -= (subfinalPrice * (discount.getPercentage() / 100));
        }

        Tax taxes = new Tax(0, null, 0);

        float porcentualFactor = taxes.getAllTaxes().getLast().getPorcentFloat();

        dataToGeneratebill += "\n[Taxes] IVA 12%: " + (subfinalPrice * porcentualFactor) + "\n";
        dataToGeneratebill += "Final Price: " + (subfinalPrice * (porcentualFactor + 1)) + "\n";

        Bill bill = new Bill(customer, kart, discountsToAplly);
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

    public void computeTotalPrice() {
        float totalPrice = 0;
        float totalEarnings = 0;
        float totalTaxes = 0;
        float earnings = 0;
        for (ProductItem productItem : products) {
            totalPrice += (productItem.getProduct().getPvp() * productItem.getUnits());
            earnings = (float) ((productItem.getProduct().getPvp() * productItem.getUnits()) - (productItem.getProduct().getCost() * productItem.getUnits()));
            totalEarnings += earnings;
            totalTaxes += (earnings * 0.12);

            earnings = 0;
        }

        this.totalPrice = totalPrice;
        this.totalEarnings = totalEarnings;
    }
}

