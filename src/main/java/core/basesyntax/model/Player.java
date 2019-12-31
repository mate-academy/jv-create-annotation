package core.basesyntax.model;

import java.util.Objects;

public class Player {
    private String firstName;
    private String lastName;
    private int age;
    private Bet bet;

    public Player(String firstName, String lastName, int age, Bet bet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bet = bet;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return age == player.age
                && Objects.equals(firstName, player.firstName)
                && Objects.equals(lastName, player.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Player{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", age=" + age
                + ", bet=" + bet
                + '}';
    }
}
