package core.basesyntax.dao;

import core.basesyntax.database.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.RequestBarvinok;

import java.util.List;

@Dao
public class BarvinokDaoImpl implements BarvinokDao {
    @Override
    public void makeBarvinokRequest(RequestBarvinok requestBarvinok) {
        Storage.requestBarvinok.add(requestBarvinok);
    }

    @Override
    public List<RequestBarvinok> getAllList() {
        return Storage.requestBarvinok;
    }
}
