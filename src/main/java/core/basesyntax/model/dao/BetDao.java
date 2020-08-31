package core.basesyntax.model.dao;

import core.basesyntax.model.model.Bet;
import java.util.List;

public interface BetDao {

    void add(Bet bet);

    List<Bet> getAll();
}
