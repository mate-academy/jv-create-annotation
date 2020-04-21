package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class<?> clazz) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException, InstantiationException {

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Object initializer;

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                initializer = field.getType() == BetDao.class
                        && Factory.getBetDao().getClass().getAnnotation(Dao.class) != null
                        ? Factory.getBetDao()
                        : field.getType() == UserDao.class
                        && Factory.getUserDao().getClass().getAnnotation(Dao.class) != null
                        ? Factory.getUserDao()
                        : null;
                field.set(instance, initializer);
            }
        }
        return instance;
    }
}

