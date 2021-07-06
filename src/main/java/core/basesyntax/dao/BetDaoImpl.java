package core.basesyntax.dao;

import core.basesyntax.database.Storage;
import core.basesyntax.models.Bet;

import java.util.List;

public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.bets;
    }
}
