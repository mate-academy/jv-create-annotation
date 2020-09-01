package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import java.util.List;

@Dao
public class BetDaoImpl implements GenericDao<Bet> {

    @Override
    public void addModelToDb(Bet bet) {
        Storage.BETS_STORAGE.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.BETS_STORAGE;
    }
}
