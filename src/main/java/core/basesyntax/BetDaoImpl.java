package core.basesyntax;

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
