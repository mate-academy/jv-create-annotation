package core.basesyntax.dao;

import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import db.Storage;
import java.util.List;

@Dao
public class BetDaoImpl implements UniversalDao<Bet> {
    @Override
    public void add(Bet value) {
        Storage.bets.add(value);
    }

    @Override
    public List<Bet> getAll() {
        return null;
    }
}
