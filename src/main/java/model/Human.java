package model;

public class Human{

    private String name;
    private int money;

    public Human(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void setMoney(int value) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "You are:{" + name + ", and you ready to spend" + money + "}";
    }
}
