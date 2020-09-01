package core.basesyntax.model;

public class Bet {
    private int value;
    private double risk;
    private BetUser betUser;

    public Bet(int value, double risk, BetUser betUser) {
        this.value = value;
        this.risk = risk;
        this.betUser = betUser;
    }

    public int getValue() {
        return value;
    }

    public double getRisk() {
        return risk;
    }

    public BetUser getBetUser() {
        return betUser;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    public void setBetUser(BetUser betUser) {
        this.betUser = betUser;
    }

    @Override
    public String toString() {
        return "Bet{"
                + "value=" + value
                + ", risk=" + risk
                + ", " + betUser
                + '}';
    }
}
