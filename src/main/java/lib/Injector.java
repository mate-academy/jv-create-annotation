package lib;

import dao.BetDao;
import dao.UserDao;
import exceptions.AnnotationIsFailureException;
import factory.DaoFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getType().equals(BetDao.class)
                        && DaoFactory.getBetDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(instance, DaoFactory.getBetDao());
                } else if (field.getType().equals(UserDao.class)
                        && DaoFactory.getUserDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(instance, DaoFactory.getUserDao());
                } else {
                    throw new AnnotationIsFailureException("The required annotation is missing");
                }
            }
        }
        return instance;
    }
}
