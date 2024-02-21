package ec.edu.espe.viveresgabysoftwarekit.view;

import ec.edu.espe.viveresgabysoftwarekit.controller.BillHandler;
import javax.mail.MessagingException;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Mateo
 * García-HONEYBUDGERS-DCCO-14575
 */
public class ViveresGabySoftwareKit {

    public static FrmNewSell frmNewSell = new FrmNewSell();

    public static void main(String[] args) throws MessagingException {

        BillHandler billHandler = new BillHandler();
        System.out.println(billHandler.getAllBills());
        FrmSplashScreen frmSplashScreen = new FrmSplashScreen();
        frmSplashScreen.init();
    }

}
