package core.basesyntax.model;

public class User {
    private String login;
    private int userBet;

    public User(String login, int userBets) {
        this.login = login;
        this.userBet = userBet;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getUserBet() {
        return userBet;
    }

    public void setUserBet(int userBets) {
        this.userBet = userBet;
    }

    @Override
    public String toString() {
        return "User {"
                + "login= " + login + '\''
                + ", userBets= " + userBet + "}";
    }
}
