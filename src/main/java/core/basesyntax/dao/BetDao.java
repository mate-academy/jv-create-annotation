package core.basesyntax.dao;

import core.basesyntax.models.Bet;
import java.util.List;

public interface BetDao {
    void add(Bet bet);

    List<Bet> getAll();
}