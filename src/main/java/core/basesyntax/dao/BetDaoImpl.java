package core.basesyntax.dao;

import core.basesyntax.data.BetStorage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import java.util.List;

@Dao
public class BetDaoImpl implements BetDao {

    @Override
    public void add(Bet bet) {
        BetStorage.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return BetStorage.bets;
    }
}
