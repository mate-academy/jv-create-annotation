package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.models.Human;
import java.util.List;

@Dao
public class HumanDaoImpl implements HumanDao {

    @Override
    public void add(Human human) {
        Storage.HUMANS.add(human);
    }

    @Override
    public List<Human> getAll() {
        return Storage.HUMANS;
    }
}
