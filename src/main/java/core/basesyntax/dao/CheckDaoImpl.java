package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Check;
import java.util.List;

public class CheckDaoImpl implements CheckDao {
    @Override
    public void add(Check check) {
        Storage.checks.add(check);
    }

    @Override
    public List<Check> getAll() {
        return Storage.checks;
    }
}
