package core.basesyntax.dao;

import core.basesyntax.database.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.RequestVeselka;

import java.util.List;

@Dao
public class VeselkaDaoImpl implements VeselkaDao {
    @Override
    public void makeVeselkaRequest(RequestVeselka requestVeselka) {
        Storage.requestVeselka.add(requestVeselka);
    }

    @Override
    public List<RequestVeselka> getAllList() {
        return Storage.requestVeselka;
    }
}
