
package ec.edu.espe.viveresgabysoftwarekit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */
public class Transaction {

    private int id;
    private boolean isCashPayment;
    private Date date;
    private float ammount;
    private Customer customer;

    List<Transaction> transaction = new ArrayList<>();
    public Transaction( boolean isCashPayment, float ammount, Customer customer) {
        updateTransaction();
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
        List<Transaction> transacation= new ArrayList<>();
        updateTransaction();
        transacation.add(this);
        fileHandler.saveJSONFile(transacation, Constans.TRANSACTION_FILE);
    }

    public void updateTransaction(){
        FileHandler<Transaction> fileHandler = new FileHandler();
        transaction = fileHandler.readJSONListTransaction(Constans.TRANSACTION_FILE);
    }
}