package dao;

import database.Storage;
import java.util.List;
import lib.Dao;
import model.Human;

@Dao
public class HumanDaoImpl implements HumanDao {

    @Override
    public void add(Human human) {
        Storage.users.add(human);
    }

    @Override
    public List<Human> getAll() {
        return Storage.users;
    }
}
