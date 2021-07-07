package dao;

import core.basesyntax.model.Bet;
import database.Storage;
import java.util.List;
import lib.Dao;

@Dao
public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<Bet> getAllBets() {
        return Storage.bets;
    }
}
