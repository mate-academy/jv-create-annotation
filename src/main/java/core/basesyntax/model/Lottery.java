package core.basesyntax.model;

public class Lottery {
    private double sum;
    private int number;

    public Lottery(double sum, int number) {
        this.sum = sum;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Lottery{"
                + "sum=" + sum
                + ", number=" + number
                + '}';
    }

    public double getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
