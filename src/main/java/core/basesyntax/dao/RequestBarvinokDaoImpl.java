package core.basesyntax.dao;

import core.basesyntax.database.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.RequestBarvinok;

import java.util.List;

@Dao
public class BarvinokDaoImpl implements RequestBarvinokDao {
    @Override
    public void makeRequest(RequestBarvinok requestBarvinok) {
        Storage.REQUEST_BARVINOK.add(requestBarvinok);
    }

    @Override
    public List<RequestBarvinok> getAllList() {
        return Storage.REQUEST_BARVINOK;
    }
}
