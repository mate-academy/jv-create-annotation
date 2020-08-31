package model;

import java.util.List;

public class User {
    public List<Bet> bets;
    private String name;
    private Double points;

    public User(String name, Double points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
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
                + "name='" + name + '\''
                + ", points=" + points
                + '}';
    }
}
