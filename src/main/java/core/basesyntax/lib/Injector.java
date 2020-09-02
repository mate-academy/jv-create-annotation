package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exceptions.NoAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredField = clazz.getDeclaredFields();
        for (Field field : declaredField) {
            annotationChecker(field);
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(UserDao.class)) {
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }

    public static void annotationChecker(Field field) {
        if (field.getType().equals(BetDao.class)
                && !BetDaoImpl.class.isAnnotationPresent(Dao.class)
                || field.getType().equals(UserDao.class)
                && !UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
            throw new NoAnnotationException("Annotation was not found.");
        }
    }
}
