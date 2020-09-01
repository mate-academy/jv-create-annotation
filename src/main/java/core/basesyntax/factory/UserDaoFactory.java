package core.basesyntax.factory;

import core.basesyntax.dao.GenericDao;
import core.basesyntax.dao.UserDaoImpl;

public class UserDaoFactory {
    private static GenericDao genericDao;

    public static GenericDao getInstance() {
        if (genericDao == null) {
            genericDao = new UserDaoImpl();
        }
        return genericDao;
    }
}
