package dao;

import db.BetStorage;
import model.Bet;
import java.util.List;

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
