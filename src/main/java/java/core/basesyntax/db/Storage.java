package java.core.basesyntax.db;

import java.core.basesyntax.model.Bet;
import java.core.basesyntax.model.Client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Storage {
    public static final List<Bet> bets = new ArrayList<>();
    public static final Set<Client> client = new HashSet<>();
}
