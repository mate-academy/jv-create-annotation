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
                BetDao betDao = BetDaoFactory.getBetDao();
                if (field.getType().equals(BetDao.class)
                        && betDao.getClass().isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(instance, betDao);
                } else {
                    UserDao userDao = UserDaoFactory.getUserDao();
                    if (field.getType().equals(UserDao.class)
                            && userDao.getClass().isAnnotationPresent(Dao.class)) {
                        field.setAccessible(true);
                        field.set(instance, userDao);
                    } else {
                        throw new NoRequiredAnnotationException(String.format(
                                "The %s class has no @Dao annotation", field.getType().getName()));
                    }
                }
            }
        }
        return instance;
    }
}
