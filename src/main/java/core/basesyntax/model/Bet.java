package core.basesyntax.model;

public class Bet {
    private int bet;
    private double risk;

    public Bet(int bet, double k) {
        this.bet = bet;
        this.risk = k;
    }

    public int getBet() {
        return bet;
    }

    public double getRisk() {
        return risk;
    }

    @Override
    public String toString() {
        return "bet: " + bet + " risk: " + risk;
    }
}
