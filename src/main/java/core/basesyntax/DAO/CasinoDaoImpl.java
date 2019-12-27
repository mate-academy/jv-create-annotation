package core.basesyntax.DAO;


import core.basesyntax.db.Storage;
import core.basesyntax.model.Casino;

import java.util.List;

public class CasinoDaoImpl implements CasinoDAO {
    @Override
    public void add(Casino casino) {
        Storage.casinos.add(casino);
    }

    @Override
    public List<Casino> getAll() {
        return Storage.casinos;
    }
}
