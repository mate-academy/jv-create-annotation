package core.basesyntax.model.dao;

import core.basesyntax.model.db.Storage;
import core.basesyntax.model.lib.Dao;
import core.basesyntax.model.model.Bet;
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
