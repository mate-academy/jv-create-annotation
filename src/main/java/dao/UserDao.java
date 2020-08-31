package dao;

import model.Bet;

public interface UserDao {

    void bet(Bet bet);

    void borrow(int points);
}
