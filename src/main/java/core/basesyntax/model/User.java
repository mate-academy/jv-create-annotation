package core.basesyntax.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int age;
    private List<Bet> userBets;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        userBets = age >= 21 ? new ArrayList<>() : null;
    }

    public int getAge() {
        return age;
    }

    public List<Bet> getUserBets() {
        return userBets;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age
                + ", userBets=" + userBets.toString() + '}';
    }
}
