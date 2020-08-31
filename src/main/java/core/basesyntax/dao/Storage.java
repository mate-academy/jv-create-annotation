package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    protected static final List<User> users = new ArrayList<>();
    protected static final List<Bet> bets = new ArrayList<>();
}
