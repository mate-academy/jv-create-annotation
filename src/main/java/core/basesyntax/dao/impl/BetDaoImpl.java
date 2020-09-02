package core.basesyntax.dao.impl;

import core.basesyntax.dao.BetDao;
import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import java.util.List;

@Dao
public class BetDaoImpl implements BetDao {

    @Override
    public boolean addBet(Bet bet) {
        return Storage.betStorage.add(bet);
    }

    @Override
    public List<Bet> getAllBets() {
        return Storage.betStorage;
    }

    @Override
    public boolean removeBet(Bet bet) {
        return Storage.betStorage.remove(bet);
    }
}
