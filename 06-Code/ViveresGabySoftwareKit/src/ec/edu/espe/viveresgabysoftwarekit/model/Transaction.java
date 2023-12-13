
package ec.edu.espe.viveresgabysoftwarekit.model;

import java.util.Date;

/**
 *
 * @author mateo, Stefany Díaz
 */
public class Transaction {

    private int id;
    private String type;
    private Date date;
    private float Ammount;
    private Customer Customer;

    public Transaction(int id, String type, Date date, float ammount, ec.edu.espe.viveresgabysoftwarekit.model.Customer customer) {
        this.id = id;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public float computerChanyel() {
        return 1;
    }
    public void seeTransactionDetails() {
    }
;
}
