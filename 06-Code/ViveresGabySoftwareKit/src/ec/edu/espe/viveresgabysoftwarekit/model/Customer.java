package ec.edu.espe.viveresgabysoftwarekit.model;

/**
 *
 * @author mateo, Stefany Díaz
 */
class Customer {

    private int id;
    private String fullname;
    private String email;
    private String address;
    private String phone;

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", fullname=" + fullname + ", email=" + email + ", address=" + address + ", phone=" + phone + '}';
    }

    public Customer(int id, String fullname, String email, String address, String phone) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
    

    private void registerClient() {
    }

    ;
    private void updateInfall() {
    }

    ;
    private void buy() {
    }

    ;
    private void getHistory() {
    }
;

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
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
