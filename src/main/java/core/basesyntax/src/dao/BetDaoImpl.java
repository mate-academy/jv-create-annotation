package core.basesyntax.src.dao;

import core.basesyntax.src.db.Storage;
import core.basesyntax.src.lib.Dao;
import core.basesyntax.src.model.Bet;

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
