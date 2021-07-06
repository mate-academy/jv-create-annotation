package core.basesyntax.factory;

import core.basesyntax.dao.PersonDao;
import core.basesyntax.dao.PersonDaoImpl;

public class PersonDaoFactory {
    public static PersonDao instance;

    public static PersonDao getPersonDao() {
        if (instance == null) {
            instance = new PersonDaoImpl();
        }
        return instance;
    }
}
