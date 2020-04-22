package core.basesyntax.model;

public class Player {
    private String name;
    private int moneyAmount;

    public Player(String name, int moneyAmount) {
        this.name = name;
        this.moneyAmount = moneyAmount;
    }

    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public Player setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
        return this;
    }

    @Override
    public String toString() {
        return "Player{" + "name='"
                + name + '\''
                + ", moneyAmount=" + moneyAmount + '}';
    }
}
