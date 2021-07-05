package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import java.util.List;

@Dao
public class BetDaoImpl implements BetDao {

    @Override
    public void add(Bet bet) {
        Storage.betsStorage.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.betsStorage;
    }

    @Override
    public boolean remove(Bet bet) {
        return Storage.betsStorage.remove(bet);
    }
}
