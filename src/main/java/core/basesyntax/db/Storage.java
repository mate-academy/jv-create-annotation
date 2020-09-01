package core.basesyntax.db;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Bet> bets = new ArrayList<>();
    public static final List<User> users = List.of(new User("l", "p", 23));

    public static User getUserByLogin(String login) {
        return users.stream()
                .filter(x -> x.getLogin().equals(login))
                .findFirst()
                .orElseThrow();
    }
}
