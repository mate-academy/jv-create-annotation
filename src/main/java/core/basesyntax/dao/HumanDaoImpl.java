package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.HumanDaoAnn;
import core.basesyntax.model.Human;

import java.util.List;

@HumanDaoAnn
public class HumanDaoImpl implements HumanDao {
    @Override
    public void add(Human human) {
        Storage.humans.add(human);
    }

    @Override
    public List<Human> getAll() {
        return Storage.humans;
    }
}
