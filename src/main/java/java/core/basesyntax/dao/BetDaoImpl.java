package java.core.basesyntax.dao;

import java.core.basesyntax.db.Storage;
import java.core.basesyntax.lib.Dao;
import java.core.basesyntax.model.Bet;

import java.util.List;

@Dao
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
