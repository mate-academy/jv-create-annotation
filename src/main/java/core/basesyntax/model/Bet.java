package core.basesyntax.model;

public class Bet {
    private int amount;
    private double risk;

    public Bet(int amount, double risk) {
        this.amount = amount;
        this.risk = risk;
    }

    public void setValue(int value) {
        this.amount = value;
    }

    public int getValue() {
        return amount;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    public double getRisk() {
        return risk;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "amount=" + amount +
                ", risk=" + risk +
                '}';
    }
}
