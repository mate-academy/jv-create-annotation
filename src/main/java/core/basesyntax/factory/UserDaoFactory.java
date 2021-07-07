package core.basesyntax.factory;

import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImp;

public class UserDaoFactory {
    private static UserDao instance;

    public static UserDao getUserDao() {
        if (instance == null) {
            instance = new UserDaoImp();
        }
        return instance;
    }
}
