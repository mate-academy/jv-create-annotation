package core.basesyntax.models;

public class BetModel {
    private int bet;
    private double risk;

    public BetModel(int bet, double risk) {
        this.bet = bet;
        this.risk = risk;
    }

    public int getBet() {
        return bet;
    }

    public double getRisk() {
        return risk;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    @Override
    public String toString() {
        return "BetModel{"
                + "bet=" + bet
                + ", risk=" + risk
                + '}';
    }
}
