package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;

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




    public Bill(Customer customer, List<ProductItem> products, Date purchaseDay, List<Discount> discounts) {
        FileHandler<Bill> fileHandler = new FileHandler<>();
        this.id = fileHandler.readJSONListBills(Constans.BILLS_FILE_NAME).getLast().id + 1;
        this.customer = customer;
        this.products = products;
        this.purchaseDay = purchaseDay;
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

    public String UIPrint(){
        return (
                "*********************************" + "\n" +
                        "\t\t" + customer.getFullname() + "\n" +
                "*********************************" + "\n" +
                "ID: " + id + "\n" +
                "Purchase Day: " + purchaseDay + "\n" +
                "Products: " +  products.size() + "\n"
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

    public void computeTotalPrice(){
        float totalPrice = 0;
        float totalEarnings = 0;
        float totalTaxes = 0;
        float earnings = 0;
        for(ProductItem productItem : products){
            totalPrice += (productItem.getProduct().getPvp() * productItem.getUnits());
            earnings = (float) ((productItem.getProduct().getPvp()*productItem.getUnits()) - (productItem.getProduct().getCost()*productItem.getUnits()));
            totalEarnings += earnings;
            totalTaxes += (earnings * 0.12);

            earnings = 0;
        }

        this.totalPrice = totalPrice;
        this.totalEarnings = totalEarnings;
    }
}