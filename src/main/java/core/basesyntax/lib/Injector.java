package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoDaoAnnotationInTheClass {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredField = clazz.getDeclaredFields();
        for (Field field : declaredField) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class) {
                    if (!BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                        throw new NoDaoAnnotationInTheClass(message(BetDaoImpl.class));
                    }
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType() == UserDao.class) {
                    if (!UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                        throw new NoDaoAnnotationInTheClass(message(UserDaoImpl.class));
                    }
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }

    private static String message(Class clazz) {
        return "Class " + clazz
                + " doesn't contains @Dao annotation!!";
    }
}
