package factory;

import dao.PersonDao;
import dao.PersonDaoImpl;
import java.lang.annotation.Annotation;
import lib.Dao;

public class PersonDaoFactory {
    private static PersonDao personDao;

    public static PersonDao getPersonDao() throws NoClassDefFoundError {
        Class<PersonDaoImpl> personDaoImpl = PersonDaoImpl.class;
        Annotation annotation = personDaoImpl.getAnnotation(Dao.class);
        if (annotation != null) {
            if (personDao == null) {
                personDao = new PersonDaoImpl();
            }
            return personDao;
        }
        throw new NoClassDefFoundError("No Dao Class selected!");
    }
}
