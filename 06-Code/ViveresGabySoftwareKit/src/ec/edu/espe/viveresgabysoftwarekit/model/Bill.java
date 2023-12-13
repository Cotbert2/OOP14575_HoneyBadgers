package ec.edu.espe.viveresgabysoftwarekit.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mateo, Stefany Díaz
 */
public class Bill {

    private int id;
    private String clientName;
    private String clientId;
    private int numProducts;
    private float totalCost;
    private Date purchaseDay;
    private ArrayList<Product> products;

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", clientName=" + clientName + ", clientId=" + clientId + ", numProducts=" + numProducts + ", totalCost=" + totalCost + ", purchaseDay=" + purchaseDay + ", products=" + products + '}';
    }

    public Bill(int id, String clientName, String clientId, int numProducts, float totalCost, Date purchaseDay, ArrayList<Product> products) {
        this.id = id;
        this.clientName = clientName;
        this.clientId = clientId;
        this.numProducts = numProducts;
        this.totalCost = totalCost;
        this.purchaseDay = purchaseDay;
        this.products = products;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the numProducts
     */
    public int getNumProducts() {
        return numProducts;
    }

    /**
     * @param numProducts the numProducts to set
     */
    public void setNumProducts(int numProducts) {
        this.numProducts = numProducts;
    }

    /**
     * @return the totalCost
     */
    public float getTotalCost() {
        return totalCost;
    }

    /**
     * @param totalCost the totalCost to set
     */
    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * @return the purchaseDay
     */
    public Date getPurchaseDay() {
        return purchaseDay;
    }

    /**
     * @param purchaseDay the purchaseDay to set
     */
    public void setPurchaseDay(Date purchaseDay) {
        this.purchaseDay = purchaseDay;
    }

    /**
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    
 }
