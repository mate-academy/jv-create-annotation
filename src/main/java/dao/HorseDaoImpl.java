package dao;

import bd.Storage;
import java.util.List;
import model.Horse;

public class HorseDaoImpl implements HorseDao {

    @Override
    public void add(Horse horse) {
        Storage.horses.add(horse);
    }

    @Override
    public List<Horse> getAll() {
        return Storage.horses;
    }
}
