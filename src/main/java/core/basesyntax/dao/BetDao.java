package core.basesyntax.dao;

import core.basesyntax.Model.Bet;

import java.util.List;

public interface BetDao {
    void add(Bet bet);
    List<Bet> getAll();
}
