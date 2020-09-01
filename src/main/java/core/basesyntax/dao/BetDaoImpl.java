package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.storage.Storage;
import java.util.List;

public class BetDaoImpl implements BetDao {
    Storage storage = new Storage();

    @Override
    public void add(Bet bet) {
        storage.getBetList().add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return storage.getBetList();
    }
}
