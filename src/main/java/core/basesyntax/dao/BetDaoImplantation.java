package core.basesyntax.dao;

import core.basesyntax.database.BetDataBase;
import core.basesyntax.model.Bet;
import java.util.List;

public class BetDaoImplantation implements BetDao {

    @Override
    public void add(Bet bet) {
        BetDataBase.betData.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return BetDataBase.betData;
    }
}


