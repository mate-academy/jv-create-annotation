package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.library.Dao;
import core.basesyntax.model.Human;
import java.util.List;

@Dao
public class HumanHumanDaoImpl implements HumanDao {

    @Override
    public void add(Human human) {
        Storage.humans.add(human);
    }

    @Override
    public List<Human> getAll() {
        return Storage.humans;
    }
}
