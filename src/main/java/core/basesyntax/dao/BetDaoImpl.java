package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.storage.ListStorageBets;
import java.util.List;

public class BetDaoImpl implements BetDao {

    @Override
    public void add(Bet bet) {
        ListStorageBets.betListStorage.add(bet);
        System.out.println(bet + " Bet added");
    }

    @Override
    public List<Bet> getAll() {
        return ListStorageBets.betListStorage;
    }
}
