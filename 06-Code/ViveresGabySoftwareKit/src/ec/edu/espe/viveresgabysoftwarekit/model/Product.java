
package ec.edu.espe.viveresgabysoftwarekit.model;

import java.io.Serializable;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class Product implements Serializable {
    private int id;
    private String name;
    private double cost;
    private double pvp;
    private String description;
    private String provider;

    public Product(String name, double cost, double pvp, String description, String provider) {
        this.name = name;
        this.cost = cost;
        this.pvp = pvp;
        this.description = description;
        this.provider = provider;
    }

    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the pvp
     */
    public double getPvp() {
        return pvp;
    }

    /**
     * @param pvp the pvp to set
     */
    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the provider
     */
    public String getProvider() {
        return provider;
    }

    /**
     * @param provider the provider to set
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", cost=" + cost + ", pvp=" + pvp + ", description=" + description + ", provider=" + provider  + '}';
    }

    public String UIPrint(){
        return "-----------------------------------\n" + "Name: " + name + "\n-----------------------------------\n"+ "Cost: " + cost + "\n" + "PVP: " + pvp + "\n" + "Description: " + description + "\n" + "Provider: " + provider  + "\n" + "-----------------------------------\n";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
   
    
