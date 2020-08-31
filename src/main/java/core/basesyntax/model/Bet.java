package core.basesyntax.model;

import java.util.Objects;

public class Bet {
    private int value;
    private double risk;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bet)) {
            return false;
        }
        Bet bet = (Bet) o;
        return value == bet.value
                && risk == bet.risk;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, risk);
    }

    @Override
    public String toString() {
        return "Bet{" + "value=" + value
                + ", risk=" + risk + '}';
    }
}
