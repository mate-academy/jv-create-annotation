package core.basesyntax.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String login;
    private String password;
    private int age;
    private List<Bet> bets;

    public User(String login, String password, int age) {
        this.login = login;
        this.password = password;
        this.age = age;
        bets = new ArrayList<>();
    }
}
