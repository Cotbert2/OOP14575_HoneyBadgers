package ec.edu.espe.viveresgabysoftwarekit.view.menus;
import ec.edu.espe.viveresgabysoftwarekit.utils.Validations;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class ConfirmDialog {
    Validations validations = new Validations();
    public boolean confirmDialog(String message){
        System.out.println("-----------------------\n"
                + message + "\n"
                + "-----------------------\n");
        System.out.print("y/n");
        return validations.getYNOption();


    }
}
