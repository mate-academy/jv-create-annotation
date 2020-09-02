package core.basesyntax.model;

public class Bet {
    private double risk;
    private int amount;

    public Bet(double risk, int amount) {
        this.risk = risk;
        this.amount = amount;
    }

    public double getRisk() {
        return risk;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bet{"
                + "risk=" + risk
                + ", amount=" + amount
                + '}';
    }
}
