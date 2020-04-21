package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
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
            injectField(instance, field,
                    BetDaoImpl.class, BetDao.class, BetDaoFactory.getBetDao());
            injectField(instance, field,
                    UserDaoImpl.class, UserDao.class, UserDaoFactory.getUserDao());
        }
        return instance;
    }

    private static void injectField(Object instance, Field field,
                                    Class<?> classImpl, Class<?> daoInstance, Object value)
            throws IllegalAccessException {
        if (classImpl.getAnnotation(Dao.class) != null && field.getAnnotation(Inject.class) != null
                && field.getType().equals(daoInstance)) {
            field.setAccessible(true);
            field.set(instance, value);
        }
    }
}
