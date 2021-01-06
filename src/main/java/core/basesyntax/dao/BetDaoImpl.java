package core.basesyntax.dao;

import core.basesyntax.db.StorageBets;
import core.basesyntax.model.Bet;
import java.util.List;

public class BetDaoImpl implements BetDao {

    @Override
    public void add(Bet bet) {
        StorageBets.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return StorageBets.bets;
    }
}
