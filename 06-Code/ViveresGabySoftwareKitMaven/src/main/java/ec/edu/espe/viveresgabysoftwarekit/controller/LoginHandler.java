
package ec.edu.espe.viveresgabysoftwarekit.controller;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.model.User;
import ec.edu.espe.viveresgabysoftwarekit.utils.Cypher;
import ec.edu.espe.viveresgabysoftwarekit.utils.DbManager;
import ec.edu.espe.viveresgabysoftwarekit.utils.Validator;
import java.util.List;

/**
 *
 * @author mateo
 */
public class LoginHandler {
    Cypher cypher = new Cypher(17);
    DbManager<User> DataBaseHandler = new DbManager<>();
    
    public boolean hasLogin(String user, String password){
        
        boolean authStatus = false;

        List<User> users = DataBaseHandler.readJSONListGeneric(Constans.USERS_FILE_NAME, User.class);
        
        if(users.isEmpty())
            System.out.println("No users registered");
        for (User userItem : users) {
            if (userItem.getUserName().equals(user) &&  userItem.getCypherPasswd() .equals(cypher.cypherMessage(password))) {
                authStatus = true;
                break;
            }
        }
        return authStatus;
    }
}
