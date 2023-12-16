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
}