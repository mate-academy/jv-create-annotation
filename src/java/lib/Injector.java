package lib;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.PersonDao;
import dao.PersonDaoImpl;
import exeptions.DaoExistExeption;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, DaoExistExeption {
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType() == PersonDao.class) {
                if (PersonDaoImpl.class.getAnnotation(Dao.class) == null) {
                    throw new DaoExistExeption();
                }
                field.setAccessible(true);
                field.set(instance, new PersonDaoImpl());
            }
            if (field.getAnnotation(Inject.class) != null
                    && field.getType() == BetDao.class) {
                if (BetDaoImpl.class.getAnnotation(Dao.class) == null) {
                    throw new DaoExistExeption();
                }
                field.setAccessible(true);
                field.set(instance, new BetDaoImpl());
            }

        }
        return instance;
    }
}
