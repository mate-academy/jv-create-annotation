package core.basesyntax.factory;

import core.basesyntax.dao.PersonDao;
import core.basesyntax.dao.PersonDaoImpl;

public class PersonFactory {
    private static PersonDao personDao;

    public static PersonDao getPersonDao() {
        if (personDao == null) {
            personDao = new PersonDaoImpl();
        }

        return personDao;
    }
}
