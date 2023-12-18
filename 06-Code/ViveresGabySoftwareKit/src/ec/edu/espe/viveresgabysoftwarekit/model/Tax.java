package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */
public class Tax {

    private int id;
    private String name;
    private int porcent;

    FileHandler<Tax> fileHandlerTax= new FileHandler();
    List<Tax> taxes = new ArrayList<>();
    private void updateTax(int id) {
        updateTaxesInfo();
        if(taxes.isEmpty()) {
            System.out.println("There are no taxes");
        }else {
            for(Tax tax: taxes){
                System.out.println(tax);
            }
        }
    }

    public Tax(int id, String name, int porcent) {
        this.id = id;
        this.name = name;
        this.porcent = porcent;
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

    public int getPorcent() {
        return porcent;
    }

    public float getPorcentFloat() {
        return (float)porcent/100;
    }

    public void setPorcent(int porcent) {
        this.porcent = porcent;
    }

    private void deleteTax() {
    }
    private void createTax() {

    }

    public void updateTaxesInfo(){
        taxes = fileHandlerTax.readJSONList(Constans.TAXES_FILE_NAME);
    }

    public void getAllTaxes(){
        updateTaxesInfo();
        for (Tax tax: taxes){
            System.out.println(tax);
        }

    }

}
