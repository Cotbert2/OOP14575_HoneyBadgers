package ec.edu.espe.viveresgabysoftwarekit.model;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCypherPasswd(String cypherPasswd) {
        this.cypherPasswd = cypherPasswd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", cypherPasswd='" + cypherPasswd + '\'' +
                '}';
    }
}
