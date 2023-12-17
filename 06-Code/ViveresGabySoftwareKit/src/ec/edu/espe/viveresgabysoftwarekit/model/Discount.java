package ec.edu.espe.viveresgabysoftwarekit.model;

import java.util.Date;

public class Discount {
    private int id;
    private String name;
    private float percentage;
    private Date startDate;
    private Date endDate;

    public Discount(int id, String name, float percentage, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void UIPrint() {
        System.out.println("--------------------------");
        System.out.println("Name: " + name);
        System.out.println("--------------------------");
        System.out.println("Percentage: " + percentage);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
    }


}
