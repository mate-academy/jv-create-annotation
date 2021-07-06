package core.basesyntax.model;

public class Bet {
    private int value;
    private Double risk;

    public Bet(int value, Double risk) {
        this.value = value;
        this.risk = risk;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Double getRisk() {
        return risk;
    }

    public void setRisk(Double risk) {
        this.risk = risk;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
