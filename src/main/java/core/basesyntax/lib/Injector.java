package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] instanceFields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        for (Field field : instanceFields) {
            if (field.getAnnotation(Dao.class) != null
                    && field.getType() == BetDao.class) {
                field.setAccessible(true);
                field.set(instance, Factory.getBetDao());
            }
            if (field.getAnnotation(Dao.class) != null
                    && field.getType() == PlayerDao.class) {
                field.setAccessible(true);
                field.set(instance, Factory.getPlayerDao());
            }
        }
        return instance;
    }
}
