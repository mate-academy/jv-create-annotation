package core.basesyntax;

import java.io.Serializable;

public class Bet implements Serializable {
    int value;
    double risk;

    public Bet(int value, double risk) {
        this.value = value;
        this.risk = risk;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    public double getRisk() {
        return risk;
    }

    public String toString() {
        return " Model bet { " +
                " value = " + value
                + " risk =  " + risk;
    }

}
