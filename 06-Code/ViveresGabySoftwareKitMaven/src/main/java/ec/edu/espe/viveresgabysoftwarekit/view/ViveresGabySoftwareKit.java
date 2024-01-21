package ec.edu.espe.viveresgabysoftwarekit.view;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.view.login.LogInSystem;
import ec.edu.espe.viveresgabysoftwarekit.view.menus.MainMenu;

import javax.mail.MessagingException;

import ec.edu.espe.viveresgabysoftwarekit.controller.Db;



/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class ViveresGabySoftwareKit {
    public static void main(String[] args) throws MessagingException {
        Db.conectToDb();
        System.out.println(Constans.WELCOME_HEADER);
        LogInSystem logInSystem = new LogInSystem();
        logInSystem.showLogin();
        MainMenu.showMenu();
    }

}
