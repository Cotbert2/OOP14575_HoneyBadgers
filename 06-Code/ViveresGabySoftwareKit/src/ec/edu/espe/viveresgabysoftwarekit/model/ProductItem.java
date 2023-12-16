
package ec.edu.espe.viveresgabysoftwarekit.model;

/**
 *
 * @author mateo, Stefany Díaz
 */
public class ProductItem {
    private Product product;
    private int units;
    public void applyDiscount(SeasonalDiscount discount){};

    public ProductItem(Product product, int units) {
        this.product = product;
        this.units = units;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
