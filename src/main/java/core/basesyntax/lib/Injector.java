package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.NoImplementationException;
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
                UserDao userDao = UserDaoFactory.getUserDao();
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && betDao.getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, betDao);
                } else if (field.getType().equals(UserDao.class)
                        && userDao.getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, userDao);
                } else {
                    throw new NoImplementationException(field.getName()
                            + " doesn't have an implementation that can be injected");
                }
            }
        }
        return instance;
    }
}
