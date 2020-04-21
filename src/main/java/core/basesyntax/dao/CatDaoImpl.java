package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Cat;
import java.util.List;

public class CatDaoImpl implements CatDao {

    @Override
    public void add(Cat cat) {
        Storage.cats.add(cat);
    }

    @Override
    public List<Cat> getAll() {
        return Storage.cats;
    }
}
