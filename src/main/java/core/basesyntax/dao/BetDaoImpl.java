package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;

import java.util.List;

//  class for work with DB and table of bets
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
