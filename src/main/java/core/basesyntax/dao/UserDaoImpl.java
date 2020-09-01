package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void saveAsGambler(User user) {
        if (User.isLegalGambling(user)) {
            Storage.legit_gamblers.add(user);
        }
    }

    @Override
    public List<User> getAllGamblers() {
        return Storage.legit_gamblers;
    }
}
