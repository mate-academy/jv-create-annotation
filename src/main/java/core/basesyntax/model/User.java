package core.basesyntax.model;

public class User {
    private String userName;
    private String password;
    private int availableAmount;

    public User(String userName, String password, int availableAmount) {
        this.userName = userName;
        this.password = password;
        this.availableAmount = availableAmount;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }
}
