package core.basesyntax.dao;

import core.basesyntax.library.Dao;
import core.basesyntax.model.Bet;
import core.basesyntax.storage.ListStorage;
import java.util.List;

@Dao
public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        ListStorage.betStorage.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return ListStorage.betStorage;
    }
}
