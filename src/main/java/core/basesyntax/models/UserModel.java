package core.basesyntax.models;

public class UserModel {
    private String userName;
    private int userBalance;

    public UserModel(String userName, int userBalance) {
        this.userName = userName;
        this.userBalance = userBalance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }

    @Override
    public String toString() {
        return "UserModel{"
                + "userName='" + userName
                + '\'' + ", userBalance="
                + userBalance + '}';
    }
}
