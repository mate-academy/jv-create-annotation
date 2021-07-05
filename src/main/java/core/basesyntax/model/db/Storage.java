package core.basesyntax.model.db;

import core.basesyntax.model.model.Bet;
import core.basesyntax.model.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Bet> bets = new ArrayList<>();
    public static final List<User> users = new ArrayList<>();
}
