package core.basesyntax.db;

import core.basesyntax.model.Bet;
import core.basesyntax.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public final static List<Bet> bets = new ArrayList<>();
    public final static List<Customer> customers = new ArrayList<>();
}
