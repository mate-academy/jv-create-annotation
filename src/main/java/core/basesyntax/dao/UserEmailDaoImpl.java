package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.UserEmail;

import java.util.List;

@Dao
public class UserEmailDaoImpl implements UserEmailDao {

    @Override
    public void add(UserEmail userEmail) {
        Storage.emails.add(userEmail);
    }

    @Override
    public List<UserEmail> getAll() {
        return Storage.emails;
    }
}
