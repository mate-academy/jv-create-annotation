package core.basesyntax.db;

import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;
import java.util.ArrayList;
import java.util.HashSet;

public class Storage {
    public static final ArrayList<Bet> bets = new ArrayList<>();
    public static final HashSet<Person> persons = new HashSet<>();
}
