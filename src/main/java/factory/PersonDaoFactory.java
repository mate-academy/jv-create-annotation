package factory;

import dao.PersonDao;
import dao.PersonDaoImpl;

public class PersonDaoFactory {
    private static PersonDao instance;

    public static PersonDao getPersonDao() {
        if (instance == null) {
            instance = new PersonDaoImpl();
        }
        return instance;
    }
}
