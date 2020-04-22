package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImpl;
import core.basesyntax.exceptions.NoAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoAnnotationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] instanceFields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        for (Field field : instanceFields) {
            if (field.getAnnotation(Dao.class) != null
                    && field.getType() == BetDao.class) {
                if (BetDaoImpl.class.getAnnotation(Dao.class) == null) {
                    throw new NoAnnotationException("");
                }
                field.setAccessible(true);
                field.set(instance, Factory.getBetDao());
            }
            if (field.getAnnotation(Dao.class) != null
                    && field.getType() == PlayerDao.class) {
                if (PlayerDaoImpl.class.getAnnotation(Dao.class) == null) {
                    throw new NoAnnotationException("");
                }
                field.setAccessible(true);
                field.set(instance, Factory.getPlayerDao());
            }
        }
        return instance;
    }
}
