package ec.edu.espe.viveresgabysoftwarekit.model;

/**
 *
 * @author mateo, Stefany Díaz, eduardo garcia
 */
public class SeasonalDiscount {
    private String date;
    private double value;

    public SeasonalDiscount(String date, double value) {
        this.date = date;
        this.value = value;
    }

    
    
    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Discount{" + "date=" + date + ", value=" + value + '}';
    }
    
    
    
}
