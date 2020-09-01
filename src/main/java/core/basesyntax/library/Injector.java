package core.basesyntax.library;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.factory.FactoryBetDao;
import core.basesyntax.factory.FactoryUserDao;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class<?> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<UserDaoImpl> userDaoClass = UserDaoImpl.class;

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                field.setAccessible(true);
                if (betDaoClass.isAnnotationPresent(Dao.class)) {
                    field.set(instance, FactoryBetDao.getBetDao());
                }
            }
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(UserDao.class)) {
                field.setAccessible(true);
                if (userDaoClass.isAnnotationPresent(Dao.class)) {
                    field.set(instance, FactoryUserDao.getUserDao());
                }
            }
        }
        return instance;
    }
}
