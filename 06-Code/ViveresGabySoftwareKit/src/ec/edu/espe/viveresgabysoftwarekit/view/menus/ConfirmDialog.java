package ec.edu.espe.viveresgabysoftwarekit.view.menus;
import ec.edu.espe.viveresgabysoftwarekit.utils.Validator;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class ConfirmDialog {
    Validator validator = new Validator();
    public boolean confirmDialog(String message){
        System.out.println("-----------------------\n"
                + message + "\n"
                + "-----------------------\n");
        System.out.print("y/n");
        return validator.getYNOption();


    }
}
