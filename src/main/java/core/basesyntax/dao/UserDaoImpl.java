package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.List;

public class UserDaoImpl implements GenericDao<User> {
    private Storage<User> storage;

    public UserDaoImpl(Storage<User> storage) {
        this.storage = storage;
    }

    @Override
    public void addModelToDb(User user) {
        storage.getModelsStorage().add(user);
    }

    @Override
    public List<User> getAll() {
        return storage.getModelsStorage();
    }
}
