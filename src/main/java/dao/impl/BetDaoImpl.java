package dao.impl;

import dao.BetDao;
import model.Bet;
import java.util.List;
import static db.Storage.bets;

public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return bets;
    }
}
