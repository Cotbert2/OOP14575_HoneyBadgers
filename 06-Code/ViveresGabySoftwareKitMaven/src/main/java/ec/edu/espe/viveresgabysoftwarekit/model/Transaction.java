
package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;

import java.util.Date;
import java.util.List;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */
public class Transaction {

    private int id;
    private boolean isCashPayment;
    private Date date;
    private float ammount;
    private Customer customer;

    public Transaction( boolean isCashPayment, float ammount, Customer customer) {
        List<Transaction> transaction =  updateTransaction();
        if(transaction.isEmpty())
            this.id = 1;
        else
            this.id = transaction.getLast().id+ 1;
        this.isCashPayment = isCashPayment;
        this.date = new Date();
        this.ammount = ammount;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getType() {
        return isCashPayment;
    }

    public void setType(boolean isCashPayment) {
        this.isCashPayment = isCashPayment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmmount() {
        return ammount;
    }

    public void setAmmount(float ammount) {
        this.ammount = ammount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public float computerChange(float price) {
        if (isCashPayment)
            return (ammount - price);
        else
            return 1;
    }

    public String seeTransactionDetails() {
        String transactionSummary = "";
        transactionSummary += "-------------------------------------------------------" +
                "\n[Transaction Details]" +
                "\nId: " + id +
                "\nDate: " + date;

        if (isCashPayment)
            transactionSummary += "\nType: Cash";
        else
            transactionSummary += "\nType: Transfer";

        transactionSummary += "\nAmmount: " + ammount ;
        transactionSummary += (customer == null? "\nCustomer: FinalCustomer" : "\nCustomer: " + customer.getFullname()) + "\n";

        return transactionSummary;
    }

    public void saveTransaction(){
        FileHandler<Transaction> fileHandler = new FileHandler();
        List<Transaction> transactions= updateTransaction();
        transactions.add(this);
        fileHandler.saveJSONFile(transactions, Constans.TRANSACTION_FILE);
    }

    public  List<Transaction> updateTransaction(){
        FileHandler<Transaction> fileHandler = new FileHandler();
        return fileHandler.readJSONListGeneric(Constans.TRANSACTION_FILE, Transaction.class);
    }
}