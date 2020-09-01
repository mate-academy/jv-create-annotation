package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.models.BetModel;
import java.util.List;

@Dao
public class BetDaoImpl implements BetDao {
    @Override
    public void add(BetModel bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<BetModel> getAll() {
        return Storage.bets;
    }
}
