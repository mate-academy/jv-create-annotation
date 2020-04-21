package core.basesyntax.model;

public class Person {
    private String name;
    private String surname;
    private Bet bets;

    public Person(String name, String surname, Bet bets) {
        this.name = name;
        this.surname = surname;
        this.bets = bets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Bet getBets() {
        return bets;
    }

    public void setBets(Bet bets) {
        this.bets = bets;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", bets=" + bets.toString()
                + '}';
    }
}
