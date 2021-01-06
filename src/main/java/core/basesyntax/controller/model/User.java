package core.basesyntax.controller.model;

import java.util.List;

public class User {
    private String userName;
    private List<Bet> bets;

    public User(String name, List<Bet> bets) {
        this.userName = name;
        this.bets = bets;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + userName + '\''
                + ", bets=" + bets
                + '}';
    }
}
