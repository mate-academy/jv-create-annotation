package core.basesyntax;

import java.util.List;

@Dao
public class BetDaoImpl implements BetDao {

    @Override
    public void add(Bet bet) {
        Storage.getBetList().add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.getBetList();
    }
}
