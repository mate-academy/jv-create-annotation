package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Credit;
import java.util.List;

@Dao
public class CreditDaoImpl implements CreditDao {
    @Override
    public void add(Credit credit) {
        Storage.credits.add(credit);
    }

    @Override
    public List<Credit> getAll() {
        return Storage.credits;
    }
}
