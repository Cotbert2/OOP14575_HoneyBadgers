package ec.edu.espe.viveresgabysoftwarekit.model;

/**
 *
 * @author mateo, Stefany Díaz
 */
public class Stock {

    private ProductItem fullStorage[];
    private ProductItem OnCellar[];
    private ProductItem Onstore[];

    public Stock(ProductItem[] fullStorage, ProductItem[] onCellar, ProductItem[] onstore) {
        this.fullStorage = fullStorage;
        OnCellar = onCellar;
        Onstore = onstore;
    }

    public ProductItem[] getFullStorage() {
        return fullStorage;
    }

    public void setFullStorage(ProductItem[] fullStorage) {
        this.fullStorage = fullStorage;
    }

    public ProductItem[] getOnCellar() {
        return OnCellar;
    }

    public void setOnCellar(ProductItem[] onCellar) {
        OnCellar = onCellar;
    }

    public ProductItem[] getOnstore() {
        return Onstore;
    }

    public void setOnstore(ProductItem[] onstore) {
        Onstore = onstore;
    }

    public void viewStock() {
    }
    public void generateStocReport() {
    }
}
