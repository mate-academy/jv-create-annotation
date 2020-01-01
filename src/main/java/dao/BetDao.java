package dao;

import java.util.List;

import models.Bet;

public interface BetDao {

    void add(Bet bet);

    List<Bet> getAll();
}
