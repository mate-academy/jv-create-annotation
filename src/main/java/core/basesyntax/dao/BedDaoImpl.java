package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import java.util.List;

public class BedDaoImpl implements BetDao {
    @Override
    public void addBetToStorage(Bet bet) {
        Storage.BETS.add(bet);
    }

    @Override
    public List<Bet> getAllBetsFromStorage() {
        return Storage.BETS;
    }
}
