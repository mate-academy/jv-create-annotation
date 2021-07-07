package core.basesyntax.factory;

import core.basesyntax.dao.PersonDao;
import core.basesyntax.dao.PersonDaoImpl;

public class PersonDaoFactory {
    private static PersonDao userDao;

    public static PersonDao getPersonDao() {
        if (userDao == null) {
            userDao = new PersonDaoImpl();
        }
        return userDao;
    }
}
