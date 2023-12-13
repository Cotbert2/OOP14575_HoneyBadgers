package ec.edu.espe.viveresgabysoftwarekit.model;



//TODO: To String setters and getters
public class User {
    private int id;
    private String userName;
    private String cypherPasswd;

    public User(int id, String userName, String cypherPasswd) {
        this.id = id;
        this.userName = userName;
        this.cypherPasswd = cypherPasswd;
    }

    public String getCypherPasswd() {
        return cypherPasswd;
    }

    public String getUserName() {
        return userName;
    }
}
