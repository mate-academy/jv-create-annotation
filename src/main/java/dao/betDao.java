package dao;

import model.Bet;

import java.util.List;

public interface betDao {
    void add(Bet bet);
    List<Bet> getAll();
}
