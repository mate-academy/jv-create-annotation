package core.basesyntax.dao;

import core.basesyntax.db.DataBase;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;

import java.util.List;

@Dao
public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        DataBase.bets.add(bet);
    }

    @Override
    public Bet get(int number) {
        return DataBase.bets.get(number);
    }

    @Override
    public List<Bet> getAll() {
        return DataBase.bets;
    }
}
