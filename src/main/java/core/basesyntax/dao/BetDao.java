package core.basesyntax.dao;

import core.basesyntax.model.Bet;

import java.util.List;

//клас для роботи з бд і таблицею ставок
public interface BetDao {
    void add(Bet bet);
    List<Bet> getAll();


}
