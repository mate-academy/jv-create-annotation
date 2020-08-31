package core.basesyntax.dao;

import core.basesyntax.model.Bet;

public interface BetDao {
    void addBet(Bet bet);

    Bet getBet(Integer id);
}
