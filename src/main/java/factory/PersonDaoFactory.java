package factory;

import dao.PersonDao;
import dao.PersonDaoImpl;
import lib.Dao;

public class PersonDaoFactory {
    private static PersonDao personDao;

    public static PersonDao getPersonDao() throws NoClassDefFoundError {
        if (PersonDaoImpl.class.getAnnotation(Dao.class) != null) {
            if (personDao == null) {
                personDao = new PersonDaoImpl();
            }
            return personDao;
        }
        throw new NoClassDefFoundError("No Dao Class selected!");
    }
}
