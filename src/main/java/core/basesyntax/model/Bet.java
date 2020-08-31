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

    public void setValue(int value) {
        this.value = value;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bet bet = (Bet) o;
        return value == bet.value
                && Double.compare(bet.risk, risk) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, risk);
    }
}
