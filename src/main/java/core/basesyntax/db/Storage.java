package core.basesyntax.db;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage<T> {
    public static final List<User> USERS_STORAGE = new ArrayList<>();
    public static final List<Bet> BETS_STORAGE = new ArrayList<>();
}
