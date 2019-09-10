package core.basesyntax.dao;

import core.basesyntax.bd.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;

import java.util.List;

@Dao
public class BetDaoImp implements BetDao {
    @Override
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.bets;
    }
}
