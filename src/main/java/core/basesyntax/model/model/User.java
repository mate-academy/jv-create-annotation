package core.basesyntax.model.model;

public class User {
    private String login;
    private String password;
    private Bet bet;

    public User(String login, String password, Bet bet) {
        this.login = login;
        this.password = password;
        this.bet = bet;
    }

    @Override
    public String toString() {
        return "User{"
                + "login='" + login + '\''
                + ", password='" + password + '\''
                + ", bet=" + bet
                + '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }
}
