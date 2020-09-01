package core.basesyntax.factory;

import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exception.NoSuchInjectionObjectException;
import core.basesyntax.lib.Dao;

public class UserDaoFactory {
    private static UserDao userDao;

    public static UserDao getInstance() {
        if (UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
            if (userDao == null) {
                userDao = new UserDaoImpl();
            }
            return userDao;
        }
        throw new NoSuchInjectionObjectException("The required injection object was not found");
    }
}
