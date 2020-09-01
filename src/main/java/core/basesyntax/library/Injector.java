package core.basesyntax.library;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exceptions.NoSuchAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class<ConsoleHandler> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<ConsoleHandler> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        Class<? extends BetDao> betDaoClass = Factory.getBetDao().getClass();
        Class<? extends UserDao> userDaoClass = Factory.getUserDao().getClass();
        if (!betDaoClass.isAnnotationPresent(Dao.class)
                || !userDaoClass.isAnnotationPresent(Dao.class)) {
            throw new NoSuchAnnotationException("DAO");
        }
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) == null) {
                continue;
            }
            field.setAccessible(true);
            if (field.getType().equals(BetDao.class)) {
                field.set(instance, Factory.getBetDao());
            } else if (field.getType().equals(UserDao.class)) {
                field.set(instance, Factory.getUserDao());
            }
        }
        return instance;
    }
}
