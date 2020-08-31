package dao;

import database.Storage;
import model.Bet;

public class UserDaoImpl implements UserDao {
    @Override
    public void bet(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public void borrow(int points) {

    }
}
