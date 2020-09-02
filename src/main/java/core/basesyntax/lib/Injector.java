package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exception.DaoAnnotationNotFound;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, DaoAnnotationNotFound {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    if (BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                        field.set(instance, Factory.getBetDao());
                    } else {
                        throw new DaoAnnotationNotFound("BetDaoImpl haven't annotation!");
                    }
                }
                if (field.getType().equals(UserDao.class)) {
                    if (UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                        field.set(instance, Factory.getUserDao());
                    } else {
                        throw new DaoAnnotationNotFound("UserDaoImpl haven't annotation!");
                    }
                }
            }
        }
        return instance;
    }
}
