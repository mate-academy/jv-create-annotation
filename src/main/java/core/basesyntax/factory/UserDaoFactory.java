package core.basesyntax.factory;

import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;

public class UserDaoFactory {

    private static UserDao instance;

    public static UserDao getUserDao() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }
}
