package ec.edu.espe.viveresgabysoftwarekit.model.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
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

    public Financer(List<Customer> customers) {
        this.customers = customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
