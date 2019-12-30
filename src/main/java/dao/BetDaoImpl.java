package dao;

// Класс  для доступа к даным из хранилища. Кладёт и достаёт данные

import db.Storage;
import java.util.List;
import lib.Dao;
import model.Bet;

@Dao
public class BetDaoImpl implements BetDao {

    @Override
    public void add(Bet bet) {
        Storage.BETS.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.BETS;
    }
}
