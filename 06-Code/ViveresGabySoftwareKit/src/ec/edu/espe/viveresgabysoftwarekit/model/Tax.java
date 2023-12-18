package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */
class Tax {

    private int id;
    private String name;
    private int porcent;

    FileHandler<Tax> fileHandlerTax= new FileHandler();
    List<Tax> taxes = new ArrayList<>();
    private void updateTax() {
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

    public void setPorcent(int porcent) {
        this.porcent = porcent;
    }

    private void deleteTax() {
    }
    private void createTax() {

    }

    public void updateTaxesInfo(){
        taxes = fileHandlerTax.readJSONList(Constans.TAXES_FILE_NAME);

    }}
