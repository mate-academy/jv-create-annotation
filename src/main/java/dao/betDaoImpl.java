package dao;

import db.Storage;
import lib.Dao;
import model.Bet;

import java.util.List;

//Логика работы с базой данных что ы не дублировать
@Dao
//
public class betDaoImpl implements betDao {
    @Override
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.bets;
    }
}
