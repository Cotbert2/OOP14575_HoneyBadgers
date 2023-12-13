
package ec.edu.espe.viveresgabysoftwarekit.model;

/**
 *
 * @author mateo, Stefany Díaz
 */
class ProductItem {
    private int product;
    private int units;
    public void applyDiscount(SeasonalDiscount discount){};

    public ProductItem(int product, int units) {
        this.product = product;
        this.units = units;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
