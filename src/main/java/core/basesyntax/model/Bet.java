package core.basesyntax.model;

public class Bet {
    private int value;
    private double risk;

    public Bet(int value, double risk) {
        checkNegativeValue(value);
        checkNegativeRisk(risk);
        this.value = value;
        this.risk = risk;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        checkNegativeValue(value);
        this.value = value;
    }

    public double getRisk() {
        return risk;
    }

    public void setRisk(double risk) {
        checkNegativeRisk(risk);
        this.risk = risk;
    }

    private void checkNegativeValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value is negative");
        }
    }

    private void checkNegativeRisk(double risk) {
        if (risk < 0) {
            throw new IllegalArgumentException("Value is negative");
        }
    }

    @Override
    public String toString() {
        return "Bet = [" + value + " " + risk + "]";
    }
}
