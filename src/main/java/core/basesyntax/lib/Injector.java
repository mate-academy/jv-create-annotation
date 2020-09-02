package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clas) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoImplementationException {
        Constructor constructor = clas.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clas.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                BetDao betDao = Factory.getBetDao();
                UserDao userDao = Factory.getUserDao();
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && betDao.getClass().getAnnotation(Dao.class) != null) {
                    field.set(instance, betDao);
                } else if (field.getType().equals(UserDao.class)
                        && userDao.getClass().getAnnotation(Dao.class) != null) {
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
