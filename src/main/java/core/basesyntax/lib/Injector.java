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
            InstantiationException, NoClassAnnotation {
        Constructor constructor = clas.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clas.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                BetDao betDao = Factory.getBetDao();
                if (field.getType().equals(BetDao.class)
                        && betDao.getClass().getAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(instance, betDao);
                } else {
                    UserDao userDao = Factory.getUserDao();
                    if (field.getType().equals(UserDao.class)
                            && userDao.getClass().getAnnotation(Dao.class) != null) {
                        field.setAccessible(true);
                        field.set(instance, userDao);
                    } else {
                        throw new NoClassAnnotation("DaoImpl class has no @Dao annotation");
                    }
                }
            }
        }
        return instance;
    }
}
