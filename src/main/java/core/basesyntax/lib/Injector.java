package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exceptions.NoAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoAnnotationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<UserDaoImpl> userDaoClass = UserDaoImpl.class;
        if (!(betDaoClass.isAnnotationPresent(Dao.class))
                || !(userDaoClass.isAnnotationPresent(Dao.class))) {
            throw new NoAnnotationException("No annotation was found");
        }
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(UserDao.class)) {
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }
}
