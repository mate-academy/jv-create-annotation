package core.basesyntax.factory;

import core.basesyntax.dao.UserEmailDao;
import core.basesyntax.dao.UserEmailDaoImpl;

public class UserEmailDaoFactory {
    private static UserEmailDao instance;

    public static UserEmailDao getUserEmailDao() {
        if (instance == null) {
            instance = new UserEmailDaoImpl();
        }
        return instance;
    }
}
