package model;

public class Human {
    private String name;
    private int age;
    private Bet bet;

    public Human(String name, int age, Bet bet) {
        this.name = name;
        this.age = age;
        this.bet = bet;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public Human(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
