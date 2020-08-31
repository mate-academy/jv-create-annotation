package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import java.util.List;

public class BetDaoImpl implements ModelDao<Bet> {
    private Storage<Bet> betStorage;

    public BetDaoImpl(Storage<Bet> betStorage) {
        this.betStorage = betStorage;
    }

    @Override
    public void addModelToDb(Bet bet) {
        betStorage.getModelsStorage().add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return betStorage.getModelsStorage();
    }
}
