package dao;

import db.Storage;
import java.util.List;
import lib.Dao;
import model.SmartPhone;

@Dao
public class SmartPhoneDaoImpl implements SmartPhoneDao {
    @Override
    public void add(SmartPhone smartPhone) {
        Storage.smartPhones.add(smartPhone);
    }

    @Override
    public List<SmartPhone> getAll() {
        return Storage.smartPhones;
    }
}
