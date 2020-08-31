package core.basesyntax.db;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Bet> betStorage = new ArrayList<>();
    public static final List<User> userStorage = new ArrayList<>();
}
