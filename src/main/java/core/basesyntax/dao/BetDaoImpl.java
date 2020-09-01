package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.storage.ListStorage;
import java.util.List;

public class BetDaoImpl implements BetDao {

    @Override
    public void add(Bet bet) {
        ListStorage.betStorage.add(bet);
        System.out.println(bet + " Bet added");
    }

    @Override
    public List<Bet> getAll() {
        return ListStorage.betStorage;
    }
}
