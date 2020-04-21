package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import java.util.List;

@Dao
public class BetDaoImpl implements BetDao {
    private Storage<Bet> betStorage;

    private BetDaoImpl() {
        this.betStorage = new Storage<>();
    }

    private static class BetDaoHolder {
        private static BetDao betDao = new BetDaoImpl();
    }

    public static BetDao getInstance() {
        return BetDaoHolder.betDao;
    }

    @Override
    public void add(Bet item) {
        betStorage.add(item);
    }

    @Override
    public List<Bet> getAll() {
        return betStorage.getItems();
    }
}
