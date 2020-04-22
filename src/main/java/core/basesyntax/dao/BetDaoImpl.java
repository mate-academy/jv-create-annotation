package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import java.util.List;

@Dao
public class BetDaoImpl implements BetDao {
    private Storage<Bet> betStorage;

    public BetDaoImpl() {
        this.betStorage = new Storage<>();
    }

    @Override
    public void add(Bet item) {
        betStorage.items.add(item);
    }

    @Override
    public List<Bet> getAll() {
        return betStorage.items;
    }
}
