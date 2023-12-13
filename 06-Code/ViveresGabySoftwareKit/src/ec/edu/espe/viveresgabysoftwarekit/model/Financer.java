package ec.edu.espe.viveresgabysoftwarekit.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefany Díaz
 */
public class Financer {
    private List<Customer> customers;

    public Financer() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        if(customer != null){
            this.customers.add(customer);
        }
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

}
