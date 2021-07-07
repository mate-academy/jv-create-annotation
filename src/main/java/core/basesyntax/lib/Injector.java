package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.DaoFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        BetDao betDao = DaoFactory.getBetDao();
        UserDao userDao = DaoFactory.getUserDao();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && betDao.getClass().getAnnotation(Dao.class) != null) {
                    field.set(instance, betDao);
                    continue;
                }
                if (field.getType().equals(UserDao.class)
                        && userDao.getClass().getAnnotation(Dao.class) != null) {
                    field.set(instance, userDao);
                    continue;
                }
                throw new RuntimeException(
                        String.format("No @Dao class for %s field found", field.getName()));
            }
        }
        return instance;
    }
}
