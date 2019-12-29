package dao;

import db.Storage;
import lib.Dao;
import model.Human;

import java.util.List;

@Dao
public class HumanDaoIml implements HumanDao{
    public void addHuman(Human human){
        Storage.humans.add(human);
    }
    public List<Human> getAll(){
        return Storage.humans;
    }
}
