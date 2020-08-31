package core.basesyntax;

import java.util.List;

public class BetDaoImpl implements BetDao {
    BetStorage betStorage = new BetStorage();

    @Override
    public void add(Bet bet) {
        betStorage.getBetList().add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return betStorage.getBetList();
    }
}
