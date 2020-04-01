package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Lottery;

import java.util.List;

@Dao
public class LotteryDaoImp implements LotteryDao {

    @Override
    public void add(Lottery lottery) {
        Storage.lotteries.add(lottery);
    }

    @Override
    public List<Lottery> getAll() {
        return Storage.lotteries;
    }
}
