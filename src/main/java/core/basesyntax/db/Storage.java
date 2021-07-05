package core.basesyntax.db;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<User> users = new ArrayList<>();
    private static List<Bet> bets = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static List<Bet> getBets() {
        return bets;
    }
}
