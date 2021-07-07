package core.basesyntax.factory;

import core.basesyntax.dao.PersonDao;
import core.basesyntax.dao.PersonDaoImpl;

public class PersonDaoFactory {
    private static PersonDao personDao;

    public static PersonDao getPersonDao() {
        if (personDao == null) {
            personDao = new PersonDaoImpl();
        }
        return personDao;
    }
}
