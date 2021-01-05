package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void saveAsGambler(User user) {
        if (user.isLegalGambling()) {
            Storage.legitGamblers.add(user);
        }
    }

    @Override
    public List<User> getAllGamblers() {
        return Storage.legitGamblers;
    }
}
