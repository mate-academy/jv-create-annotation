package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import java.util.List;

public interface BetDao {
    public void add(Bet bet);

    List<Bet> getAll();
}
