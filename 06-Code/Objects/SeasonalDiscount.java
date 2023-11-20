public class SeasonalDiscount{
    private int id;
    private String name;
    private float porcent;
    private Date startDate;
    private Date endDate;
    private Product[] products;

    public void applyDiscount(){};
    public void stopDiscount(){};
    public void generateDiscountReport(){}; 
}
