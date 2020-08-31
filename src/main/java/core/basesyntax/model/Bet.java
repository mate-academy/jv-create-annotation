package core.basesyntax.model;

public class Bet {
    private int value;
    private double risk;

    public Bet(int value, double risk) {
        this.value = value;
        this.risk = risk;
    }

    @Override
    public String toString() {
        return "Bet{" + "value=" + value + ", risk=" + risk + '}';
    }
}
