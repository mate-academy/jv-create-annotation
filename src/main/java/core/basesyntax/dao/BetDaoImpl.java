package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import java.util.List;
import java.util.NoSuchElementException;

public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        Storage.bets_storage.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.bets_storage;
    }

    @Override
    public boolean remove(Bet bet) {
        return Storage.bets_storage.remove(bet);
    }

    @Override
    public void updateMoney(Bet bet, int money) {
        int index = Storage.bets_storage.indexOf(bet);
        if (index != -1) {
            Storage.bets_storage.get(index).setMoney(money);
            return;
        }
        throw new NoSuchElementException("No such element");
    }
}
