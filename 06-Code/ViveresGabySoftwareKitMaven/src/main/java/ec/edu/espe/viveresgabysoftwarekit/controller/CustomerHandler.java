package ec.edu.espe.viveresgabysoftwarekit.controller;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.model.Customer;
import ec.edu.espe.viveresgabysoftwarekit.utils.DbManager;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mateo
 */
public class CustomerHandler {

    private List<Customer> customers;
    DbManager<Customer> DbHandler = new DbManager<>();
    
    
    public void createCustomer(int id, String fullname, String email, String address, String phone) {
        //TODO: validations
        updateCustomersInfor();

        Customer newCustomer = new Customer(id, fullname, email, address, phone);

        customers.add(newCustomer);
        DbHandler.saveCollection(customers, Constans.CUSTOMERS_FILE_NAME);

        JOptionPane.showMessageDialog(null, "El usuario " + fullname + " ha sio agregado exitosamente");
    }
    
    

    public void updateCustomersInfor() {
        customers = DbHandler.readJSONListGeneric(Constans.CUSTOMERS_FILE_NAME, Customer.class);
    }

    public List<Customer> getCustomers() {
        updateCustomersInfor();
        return customers;
    }

}
