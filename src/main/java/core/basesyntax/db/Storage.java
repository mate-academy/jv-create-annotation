package core.basesyntax.db;

import core.basesyntax.models.Bet;
import core.basesyntax.models.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Bet> bets = new ArrayList<>();
    public static final List<User> users = new ArrayList<>();
}
