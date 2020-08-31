package core.basesyntax.model.dao;

import core.basesyntax.model.db.Storage;
import core.basesyntax.model.model.Bet;
import java.util.List;

public class BetDaoImpl implements Dao<Bet> {

    @Override
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.bets;
    }
}
