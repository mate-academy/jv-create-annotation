package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field: declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getType() == UserDao.class) {
                    field.setAccessible(true);
                    UserDao userDao = Factory.getUserDao();
                    if (userDao.getClass().isAnnotationPresent(Dao.class)) {
                        field.set(instance, userDao);
                    }
                } else if (field.getType() == BetDao.class) {
                    field.setAccessible(true);
                    BetDao betDao = Factory.getBetDao();
                    if (betDao.getClass().isAnnotationPresent(Dao.class)) {
                        field.set(instance,betDao);
                    }
                }
            }
        }

        return instance;
    }
}
