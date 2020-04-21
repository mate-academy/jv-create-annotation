package lib;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.PersonDao;
import dao.PersonDaoImpl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType() == PersonDao.class
                    && PersonDaoImpl.class.getAnnotation(Dao.class) != null) {
                field.setAccessible(true);
                field.set(instance, new PersonDaoImpl());
            }
            if (field.getAnnotation(Inject.class) != null
                    && field.getType() == BetDao.class
                    && BetDaoImpl.class.getAnnotation(Dao.class) != null) {
                field.setAccessible(true);
                field.set(instance, new BetDaoImpl());
            }

        }
        return instance;
    }
}
