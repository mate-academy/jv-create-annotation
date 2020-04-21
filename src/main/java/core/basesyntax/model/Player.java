package core.basesyntax.model;

import java.util.List;

public class Player {
    private String name;
    private List<Bet> bets;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    @Override
    public String toString() {
        return "Player{"
                + "name='" + name + '\''
                + ", bets=" + bets
                + '}';
    }
}
