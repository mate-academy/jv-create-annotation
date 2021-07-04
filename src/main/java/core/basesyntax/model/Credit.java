package core.basesyntax.model;

public class Credit {
    private int loan;
    private double interestRate;

    public Credit(int loan, double interestRate) {
        this.loan = loan;
        this.interestRate = interestRate;
    }

    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Credit{" + "loan=" + loan
                + ", interestRate=" + interestRate + '}';
    }
}
