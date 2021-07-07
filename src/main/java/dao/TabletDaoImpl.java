package dao;

import db.Storage;
import java.util.List;
import lib.Dao;
import model.Tablet;

@Dao
public class TabletDaoImpl implements TabletDao {

    @Override
    public void add(Tablet tablet) {
        Storage.tablets.add(tablet);
    }

    @Override
    public List<Tablet> getAll() {
        return Storage.tablets;
    }
}
