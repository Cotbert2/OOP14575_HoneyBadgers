package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mateo, Stefany Díaz
 */
public class Bill {

    private int id;

    private Customer customer;
    private List<ProductItem> products;
    private Date purchaseDay;

    FileHandler<Bill> fileHandler = new FileHandler<>();

    public Bill(int id, Customer customer, List<ProductItem> products, Date purchaseDay) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.purchaseDay = purchaseDay;
    }

    public void generateBill(){

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
}