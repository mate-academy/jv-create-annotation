package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.dao.PersonDaoImpl;

public class Factory {
    public static BetDao betDao;
    public static PersonDao person;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static PersonDao getPersonDao() {
        if (person == null) {
            person = new PersonDaoImpl();
        }
        return person;
    }
}
