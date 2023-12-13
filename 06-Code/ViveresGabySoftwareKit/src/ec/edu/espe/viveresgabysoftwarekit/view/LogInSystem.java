package ec.edu.espe.viveresgabysoftwarekit.view;

import ec.edu.espe.viveresgabysoftwarekit.utils.*;
import ec.edu.espe.viveresgabysoftwarekit.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class LogInSystem {

    Scanner in = new Scanner(System.in);
    Cypher cypher = new Cypher(17);
    FileHandler<User> fileHandler = new FileHandler<>();

    public boolean authenticate(String user, String password) {
        boolean authStatus = false;
        List<User> users = fileHandler.readJSONList(Constans.USERS_FILE_NAME);

        for (User userItem : users) {
            if (userItem.getUserName().equals(user) && userItem.getCypherPasswd().equals(password)) {
                authStatus = true;
                break;
            }
        }
        return authStatus;

    }

    public void showLogin() {
        String username = "";
        String passwd = "";
        do {
            System.out.println("********** WELCOME TO VIVERES GABY SOFTWARE KIT **********");
            System.out.println("Please enter your user and password");
            System.out.print("User: ");
            username = in.nextLine();
            System.out.print("Password: ");
            passwd = in.nextLine();
        } while (!authenticate(username, cypher.cypherMessage(passwd)));

    }
}
