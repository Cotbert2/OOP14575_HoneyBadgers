
package ec.edu.espe.viveresgabysoftwarekit.model;

import java.util.Date;

/**
 *
 * @author mateo, Stefany Díaz
 */
public class Transaction {

    private int id;
    private boolean isCashPayment;
    private Date date;
    private float Ammount;
    private Customer Customer;

    public Transaction(int id, boolean isCashPayment, Date date, float ammount, Customer customer) {
        this.id = id;
        this.isCashPayment = isCashPayment;
        this.date = date;
        Ammount = ammount;
        Customer = customer;
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
        return Ammount;
    }

    public void setAmmount(float ammount) {
        Ammount = ammount;
    }

    public ec.edu.espe.viveresgabysoftwarekit.model.Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(ec.edu.espe.viveresgabysoftwarekit.model.Customer customer) {
        Customer = customer;
    }

    public float computerChanyel(float ammount, float price) {
        if(isCashPayment)
            return (ammount - price);
        else
            return 1;
    }
    public void seeTransactionDetails() {
    }
;
}
