package model;

public class Person {
    private static int id = 0;
    private Bet bet;
    private String name;

    public Person(Bet bet, String name) {
        this.bet = bet;
        this.name = name;
        id++;
    }

    @Override
    public String toString() {
        return "Person{" + ", name='" + name + '\'' + ", id=" + id + '}';
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
