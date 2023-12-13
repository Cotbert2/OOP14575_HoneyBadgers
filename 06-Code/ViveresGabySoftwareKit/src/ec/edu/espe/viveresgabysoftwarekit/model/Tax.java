package ec.edu.espe.viveresgabysoftwarekit.model;

/**
 *
 * @author mateo, Stefany Dìaz
 */
class Tax {

    private int id;
    private String name;
    private int porcent;

    private void updateTax() {
    }

    ;

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

    ;
    private void createTax() {
    }
;
}
