package core.basesyntax.model;

public class Player {
    private String userName;
    private String password;

    public Player(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player{"
                + "userName= " + userName
                + ", password= " + password
                + '}';
    }
}
