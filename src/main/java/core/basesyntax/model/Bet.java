package core.basesyntax.model;

public class Bet {
    private int money;
    private double chanceOfVictory;

    public Bet(int money, double chanceOfVictory) {
        this.money = money;
        this.chanceOfVictory = chanceOfVictory;
    }

    @Override
    public String toString() {
        return "money = " + money
                + ", chanceOfVictory = " + chanceOfVictory;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public double getChanceOfVictory() {
        return chanceOfVictory;
    }

    public void setChanceOfVictory(double chanceOfVictory) {
        this.chanceOfVictory = chanceOfVictory;
    }
}
