package ec.edu.espe.viveresgabysoftwarekit.view;
import ec.edu.espe.viveresgabysoftwarekit.model.*;
import ec.edu.espe.viveresgabysoftwarekit.utils.Opener;
import ec.edu.espe.viveresgabysoftwarekit.view.login.LogInSystem;
import ec.edu.espe.viveresgabysoftwarekit.view.menus.InventoryMenu;
import ec.edu.espe.viveresgabysoftwarekit.view.menus.MainMenu;
import ec.edu.espe.viveresgabysoftwarekit.view.menus.Market;


import java.util.Scanner;

import javax.mail.MessagingException;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class ViveresGabySoftwareKit {

    private static MainMenu mainMenu = new MainMenu();

    public static void main(String[] args) throws MessagingException {
        System.out.println(Constans.WELCOME_HEADER);
        LogInSystem logInSystem = new LogInSystem();
        logInSystem.showLogin();
        mainMenu.showMenu();
    }

}
