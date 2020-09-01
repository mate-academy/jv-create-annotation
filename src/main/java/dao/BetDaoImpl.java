package dao;

import db.BetStorage;
import java.util.List;
import model.Bet;

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
