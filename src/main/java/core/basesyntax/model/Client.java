package core.basesyntax.model;

public class Client {
    private String fullName;
    private double debt;

    public Client(String fullName, double debt) {
        this.fullName = fullName;
        this.debt = debt;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    @Override
    public String toString() {
        return "Client{" + "fullName='" + fullName + '\''
                + ", debt=" + debt + '}';
    }
}
