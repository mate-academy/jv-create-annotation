package core.basesyntax.models;

public class Bet {
    private double value;
    private double risk;

    public Bet(double value, double risk) {
        this.risk = risk;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public double getRisk() {
        return risk;
    }

    public String toString() {
        return value + " " + risk;
    }
}
