package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import java.util.List;

@Inject
public class BetDaoImpl implements BetDao {
    @Override
    public void addBet(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.bets;
    }
}
