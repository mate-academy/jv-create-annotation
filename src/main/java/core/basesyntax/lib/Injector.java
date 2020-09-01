package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws AbsentDaoAnnotationException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchMethodException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                if (!Factory.getBetDao().getClass().isAnnotationPresent(Dao.class)) {
                    throw new AbsentDaoAnnotationException("Dao annotation is absent");
                }
                field.setAccessible(true);
                field.set(instance, Factory.getBetDao());
            }
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(UserDao.class)) {
                if (!Factory.getUserDao().getClass().isAnnotationPresent(Dao.class)) {
                    throw new AbsentDaoAnnotationException("Dao annotation is absent");
                }
                field.setAccessible(true);
                field.set(instance, Factory.getUserDao());
            }
        }
        return instance;
    }
}
