package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.library.DaoImpl;
import core.basesyntax.model.Bet;

import java.util.List;

@DaoImpl
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
