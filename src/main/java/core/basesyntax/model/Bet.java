package core.basesyntax.model;

public class Bet {
    private int value;
    private double risk;
    private User user;

    public Bet(int value, double risk, User user) {
        this.value = value;
        this.risk = risk;
        this.user = user;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getRisk() {
        return risk;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bet{"
                + "value=" + value
                + ", risk=" + risk
                + ", user=" + user
                + '}';
    }
}
