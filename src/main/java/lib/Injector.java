package lib;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.PersonDao;
import dao.PersonDaoImpl;
import exception.DaoNotExistsException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException,
            DaoNotExistsException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null && field.getType() == PersonDao.class) {
                if (PersonDaoImpl.class.getAnnotation(Dao.class) == null) {
                    throw new DaoNotExistsException();
                }
                field.setAccessible(true);
                field.set(instance, new PersonDaoImpl());
            }
            if (field.getAnnotation(Inject.class) != null && field.getType() == BetDao.class) {
                if (BetDaoImpl.class.getAnnotation(Dao.class) == null) {
                    throw new DaoNotExistsException();
                }
                field.setAccessible(true);
                field.set(instance, new BetDaoImpl());
            }
        }
        return instance;
    }
}
