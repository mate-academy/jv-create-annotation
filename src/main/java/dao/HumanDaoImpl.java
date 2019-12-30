package dao;

import db.Storage;
import java.util.List;
import lib.Dao;
import model.Human;

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
