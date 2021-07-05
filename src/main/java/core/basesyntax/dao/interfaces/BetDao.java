package core.basesyntax.dao.interfaces;

import core.basesyntax.model.Bet;
import java.util.List;

public interface BetDao {
    void add(Bet bet);

    List<Bet> getAll();
}
