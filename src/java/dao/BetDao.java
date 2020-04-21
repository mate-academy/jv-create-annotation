package dao;

import lib.Dao;
import model.Bet;

import java.util.List;

public interface BetDao {
    void addBet(Bet bet);

    List<Bet> getAll();
}
