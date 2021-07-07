package core.basesyntax.src.dao;

import core.basesyntax.src.model.Bet;

import java.util.List;

public interface BetDao {

    void add(Bet bet);

    List<Bet> getAll();
}
