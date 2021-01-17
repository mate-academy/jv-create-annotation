package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.library.Dao;
import core.basesyntax.model.BetUser;
import java.util.List;

@Dao
public class BetUserDaoImplementation implements BetUserDao {

    @Override
    public void add(BetUser betUser) {
        Storage.betUsers.add(betUser);
    }

    @Override
    public List<BetUser> getAll() {
        return Storage.betUsers;
    }
}
