package core.basesyntax.model;

public class User {
    private String name;
    private int age;
    private Bet bet;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, Bet bet) {
        this.name = name;
        this.age = age;
        this.bet = bet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", bet=" + bet + '}';
    }
}
