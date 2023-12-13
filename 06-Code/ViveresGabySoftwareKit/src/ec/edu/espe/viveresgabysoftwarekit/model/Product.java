
package ec.edu.espe.viveresgabysoftwarekit.model;

import java.io.Serializable;

/**
 *
 * @author mateo, Stefany Díaz, Eduardo García
 */

public class Product implements Serializable {
    private String name;
    private double cost;
    private double pvp;
    private String description;
    private String provider;
    private String category;

    public Product(String name, double cost, double pvp, String description, String provider, String category) {
        this.name = name;
        this.cost = cost;
        this.pvp = pvp;
        this.description = description;
        this.provider = provider;
        this.category = category;
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

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", cost=" + cost + ", pvp=" + pvp + ", description=" + description + ", provider=" + provider + ", category=" + category + '}';
    }
 
    
    
}
   
    
