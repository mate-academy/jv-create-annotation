package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.dao.PersonDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static PersonDao personDao;

    private Factory() {
    }

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static PersonDao getPersonDao() {
        if (personDao == null) {
            personDao = new PersonDaoImpl();
        }
        return personDao;
    }
}
