package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;

import java.util.List;

@Dao
public class CustomDaoClass implements BetDao {
    @Override
    public void add(Bet bet) {
        Storage.anotherBets.add(bet);
        System.out.println("Let's imagine, that it's an another implements of BetDao");
    }

    @Override
    public List<Bet> getAll() {
        System.out.println("Let's imagine, that it's an another implements of BetDao");
        return Storage.anotherBets;
    }
}
