package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;

public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }
}
