package core.basesyntax.model;

public class Bet {
    private int sum;
    private double interest;

    public Bet(int sum, double interest) {
        this.sum = sum;
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "sum=" + sum +
                ", interest=" + interest +
                '}';
    }
}
