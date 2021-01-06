package core.basesyntax.controller.dao;


import core.basesyntax.controller.model.Bet;

import java.util.List;

public interface BetDao {
    void add(Bet bet);

    List<Bet> getAll();
}
