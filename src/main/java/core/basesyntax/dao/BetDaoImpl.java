package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import java.util.List;

public class BetDaoImpl implements BetDao {
    private Storage<Bet> betStorage = new Storage<>();

    @Override
    public void add(Bet item) {
        betStorage.add(item);
    }

    @Override
    public List<Bet> getAll() {
        return betStorage.getItems();
    }
}
