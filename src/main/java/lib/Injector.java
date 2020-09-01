package lib;

import dao.BetDao;
import dao.UserDao;
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
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    field.set(instance, DaoFactory.getBetDao());
                }
                if (field.getType().equals(UserDao.class)) {
                    field.set(instance, DaoFactory.getUserDao());
                }
            }
        }
        return instance;
    }
}
