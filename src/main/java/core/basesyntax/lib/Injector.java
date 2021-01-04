package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.AnnotationException;
import core.basesyntax.factory.FactoryBetDao;
import core.basesyntax.factory.FactoryUserDao;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.newInstance();
        Object instance = constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getClass().equals(BetDao.class)
                        && field.getClass().getAnnotations().equals(Dao.class)) {
                    field.set(instance, FactoryBetDao.getBetDao());
                }
                if (field.getClass().equals(UserDao.class)) {
                    field.set(instance, FactoryUserDao.getUserDao());
                } else {
                    throw new AnnotationException("Exception was thrown in Injector");
                }
            }
        }
        return instance;
    }
}
