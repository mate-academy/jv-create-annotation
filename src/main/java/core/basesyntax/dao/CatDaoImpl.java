package core.basesyntax.dao;

import core.basesyntax.db.CatStorage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Cat;

import java.util.List;

@Dao
public class CatDaoImpl implements CatDao {
    @Override
    public void add(Cat cat) {
        CatStorage.cats.add(cat);
    }

    @Override
    public List<Cat> getAll() {
        return CatStorage.cats;
    }
}
