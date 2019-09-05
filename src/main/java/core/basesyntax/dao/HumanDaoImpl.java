package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.InjectDao;
import core.basesyntax.model.Human;

import java.util.List;

@InjectDao
public class HumanDaoImpl implements HumanDao {

    @Override
    public void add(Human human) {
        Storage.human.add(human);
    }

    @Override
    public List<Human> human() {
        return Storage.human;
    }
}
