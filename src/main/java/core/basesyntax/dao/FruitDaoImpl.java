package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Fruit;
import java.util.List;

@Dao
public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.dbFruits.add(fruit);
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.dbFruits;
    }
}
