package dao;

import db.Storage;

import java.util.List;

import lib.Dao;
import model.Human;

@Dao
public class HumanDaoIml implements HumanDao {
    public void addHuman(Human human) {
        Storage.humans.add(human);
    }

    public List<Human> getAll() {
        return Storage.humans;
    }
}
