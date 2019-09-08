package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.DaoHuman;
import core.basesyntax.model.Human;

import java.util.List;

@DaoHuman
public class HumanDaoImpl implements HumanDao{
    @Override
    public void add(Human human) {
        Storage.humans.add(human);
    }

    @Override
    public List<Human> getAll() {
        return Storage.humans;
    }
}
