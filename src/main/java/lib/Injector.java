package lib;

import dao.BetDao;
import dao.PersonDao;
import factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getType() == BetDao.class) {
                    field.setAccessible(true);
                    BetDao betDao = Factory.getBetDao();
                    if (betDao.getClass().isAnnotationPresent(Dao.class)) {
                        field.set(instance, betDao);
                    }
                } else if (field.getType() == PersonDao.class) {
                    field.setAccessible(true);
                    PersonDao personDao = Factory.getPersonDao();
                    if (personDao.getClass().isAnnotationPresent(Dao.class)) {
                        field.set(instance, personDao);
                    }
                }
            }
        }
        return instance;
    }
}
