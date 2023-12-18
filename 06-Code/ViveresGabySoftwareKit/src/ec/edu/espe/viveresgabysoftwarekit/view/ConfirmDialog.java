package ec.edu.espe.viveresgabysoftwarekit.view;
import ec.edu.espe.viveresgabysoftwarekit.utils.Validator;
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
