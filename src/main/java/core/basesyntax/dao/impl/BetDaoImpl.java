package core.basesyntax.dao.impl;

import core.basesyntax.dao.BetDao;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import core.basesyntax.storage.Storage;
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
