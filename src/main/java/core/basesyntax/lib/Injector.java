package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.NoRequiredAnnotationException;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.UserDaoFactory;
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
                if (field.getType().equals(BetDao.class)) {
                    BetDao betDao = BetDaoFactory.getBetDao();
                    if (betDao.getClass().getAnnotation(Dao.class) == null) {
                        throw new NoRequiredAnnotationException(
                                "The BetDao class has no @Dao annotation");
                    }
                    field.setAccessible(true);
                    field.set(instance, betDao);
                }
                if (field.getType().equals(UserDao.class)) {
                    UserDao userDao = UserDaoFactory.getUserDao();
                    if (userDao.getClass().getAnnotation(Dao.class) == null) {
                        throw new NoRequiredAnnotationException(
                                "The UserDao class has no @Dao annotation");
                    }
                    field.setAccessible(true);
                    field.set(instance, userDao);
                }
            }
        }
        return instance;
    }
}
