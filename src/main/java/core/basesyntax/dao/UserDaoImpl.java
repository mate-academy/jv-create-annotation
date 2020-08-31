package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Storage.users.add(user);
    }

    @Override
    public void delete(User user) {
        Storage.users.remove(user);
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }

    @Override
    public User getUserById(int id) {
        return Storage.users.get(id);
    }

    @Override
    public User getUserByName(String name) {
        return Storage.users.stream().filter(n -> n.getName().equals(name)).findFirst().get();
    }

    @Override
    public String getUserPassword(String name) {
        User user = getUserByName(name);
        return user.getPassword();
    }
}
