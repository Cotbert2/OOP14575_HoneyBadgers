package ec.edu.espe.viveresgabysoftwarekit.view;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.view.menus.MainMenu;

import javax.mail.MessagingException;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego
 * García-HONEYBUDGERS-DCCO-14575
 */
public class ViveresGabySoftwareKit {

    public static void main(String[] args) throws MessagingException {
        FrmSplashScreen frmSplashScreen = new FrmSplashScreen();
        frmSplashScreen.init();
        
        /*
        LogInSystem logInSystem = new LogInSystem();
        logInSystem.showLogin();
        MainMenu.showMenu();
         */
    }

}
