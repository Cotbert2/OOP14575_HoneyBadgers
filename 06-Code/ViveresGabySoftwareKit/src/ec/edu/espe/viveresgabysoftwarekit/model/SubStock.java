package ec.edu.espe.viveresgabysoftwarekit.model;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class SubStock {
    private Product product;
    private int OnGroceryUnits;
    private int OnStorageUnits;

    public SubStock(Product product, int OnGroceryUnits, int OnStorageUnits) {
        this.product = product;
        this.OnGroceryUnits = OnGroceryUnits;
        this.OnStorageUnits = OnStorageUnits;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOnGroceryUnits() {
        return OnGroceryUnits;
    }

    public void setOnGroceryUnits(int onGroceryUnits) {
        OnGroceryUnits = onGroceryUnits;
    }

    public int getOnStorageUnits() {
        return OnStorageUnits;
    }

    public void setOnStorageUnits(int onStorageUnits) {
        OnStorageUnits = onStorageUnits;
    }


    public String UIPrint(){
        return (product.getId() + "\t" + product.getName() + "\t" + OnGroceryUnits + "\t" + OnStorageUnits + "\t" + (OnGroceryUnits + OnStorageUnits) + "\n");
    }
}
