package core.basesyntax.model;

public class Bet {
    int value;
    double risk;

    public Bet(int value, double risk) {
        this.value = value;
        this.risk = risk;
    }

    public int getValue() {
        return value;
    }

    public double getRisk() {
        return risk;
    }

    @Override
    public String toString() {
        return "Bet{" + "value="
                + value
                + ", risk="
                + risk
                + '}';
    }
}
