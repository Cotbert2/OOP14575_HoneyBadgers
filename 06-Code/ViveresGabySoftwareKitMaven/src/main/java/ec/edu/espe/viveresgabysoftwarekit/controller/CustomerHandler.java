package ec.edu.espe.viveresgabysoftwarekit.controller;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.model.Customer;
import ec.edu.espe.viveresgabysoftwarekit.utils.DbManager;
import java.util.List;

/**
 *
 * @author mateo
 */
public class CustomerHandler {

    private List<Customer> customers;
    DbManager<Customer> DbHandler = new DbManager<>();

    public void updateCustomersInfor() {
        customers = DbHandler.readJSONListGeneric(Constans.CUSTOMERS_FILE_NAME, Customer.class);
    }

    public List<Customer> getCustomers() {
        updateCustomersInfor();
        return customers;
    }

}
