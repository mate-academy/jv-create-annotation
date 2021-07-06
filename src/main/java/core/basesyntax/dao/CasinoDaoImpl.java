package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Casino;

import java.util.List;

@Dao
public class CasinoDaoImpl implements CasinoDao {
    @Override
    public void add(Casino casino) {
        Storage.casinos.add(casino);
    }

    @Override
    public List<Casino> getAll() {
        return Storage.casinos;
    }
}
