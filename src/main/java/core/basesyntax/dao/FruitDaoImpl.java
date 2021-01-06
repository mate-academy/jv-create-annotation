package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit bet) {
        Storage.dbFruits.add(bet);
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.dbFruits;
    }
}
