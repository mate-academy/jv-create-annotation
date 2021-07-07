package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Pearson;
import java.util.List;

@Dao
public class PearsonDaoImpl implements PearsonDao {

    @Override
    public void add(Pearson pearson) {
        Storage.people.add(pearson);
    }

    @Override
    public List<Pearson> getAll() {
        return Storage.people;
    }
}
