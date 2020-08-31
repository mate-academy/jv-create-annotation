package core.basesyntax.dao.impl;

import core.basesyntax.dao.BetDao;
import core.basesyntax.db.BetStorage;
import core.basesyntax.model.Bet;
import java.util.List;

public class BetDaoImpl implements BetDao {

    @Override
    public boolean addBet(Bet bet) {
        return BetStorage.betStorage.add(bet);
    }

    @Override
    public List<Bet> getAllBet() {
        return BetStorage.betStorage;
    }

    @Override
    public boolean removeBet(Bet bet) {
        return BetStorage.betStorage.remove(bet);
    }
}
