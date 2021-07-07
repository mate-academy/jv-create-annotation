package factory;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.PersonDao;
import dao.PersonDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static PersonDao personDao;

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
