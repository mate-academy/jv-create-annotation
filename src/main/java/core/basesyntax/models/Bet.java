package core.basesyntax.models;

public class Bet {
    private int value;
    private double risk;

    public Bet(int bet, double risk) {
        this.value = bet;
        this.risk = risk;
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

    @Override
    public String toString() {
        return "Bet{" + "value="
                + value + ", risk="
                + risk + '}';
    }
}
