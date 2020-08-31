package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {
    @Override
    public Optional<User> get(int id) {
        return Optional.ofNullable(Storage.getUserStorage().get(id));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(Storage.getUserStorage().values());
    }

    @Override
    public boolean save(User user) {
        Storage.getUserStorage().put(user.getId(), user);
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        Storage.getUserStorage().remove(id);
        return false;
    }
}
