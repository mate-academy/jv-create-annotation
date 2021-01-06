package core.basesyntax.db;

import core.basesyntax.model.Bet;
import core.basesyntax.model.Check;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Bet> bets = new ArrayList<>();
    public static final List<Check> checks = new ArrayList<>();
}
