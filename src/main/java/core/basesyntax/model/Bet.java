package core.basesyntax.model;

import java.util.Objects;

public class Bet {
    private int userId;
    private int value;
    private double risk;

    public Bet(int userId, int value, double risk) {
        this.userId = userId;
        this.value = value;
        this.risk = risk;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Bet bet1 = (Bet) obj;
        return value == bet1.value
                && Double.compare(bet1.risk, risk) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, risk);
    }

    @Override
    public String toString() {
        return "Bet{"
                + "value=" + value
                + ", bet=" + risk
                + '}';
    }
}
