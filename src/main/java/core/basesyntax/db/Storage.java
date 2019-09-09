package core.basesyntax.db;

import core.basesyntax.model.Bet;
import core.basesyntax.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Storage {
    public static final List<Bet> bets = new ArrayList<>();
    public static final Set<Player> players = new TreeSet<>();
}
