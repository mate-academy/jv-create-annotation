package core.basesyntax;

import java.util.List;

@Dao
public class BetImp implements BetDao {
    @Override
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.bets;
    }
}
