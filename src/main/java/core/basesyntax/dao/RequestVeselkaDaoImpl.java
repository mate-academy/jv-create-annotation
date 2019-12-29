package core.basesyntax.dao;

import core.basesyntax.database.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.RequestVeselka;

import java.util.List;

@Dao
public class RequestVeselkaDaoImpl implements RequestVeselkaDao {
    @Override
    public void makeRequest(RequestVeselka requestVeselka) {
        Storage.REQUEST_VESELKAS.add(requestVeselka);
    }

    @Override
    public List<RequestVeselka> getAllList() {
        return Storage.REQUEST_VESELKAS;
    }
}
