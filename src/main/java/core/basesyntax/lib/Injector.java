package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.exceptions.NoDaoAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws IllegalAccessException,
            InvocationTargetException, InstantiationException,
            NoSuchMethodException, NoDaoAnnotationException {

        Constructor constructor = clazz.getConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)
                    && checkDaoAnnotation(Factory.getBetDao().getClass())) {
                field.setAccessible(true);
                field.set(instance, Factory.getBetDao());
            } else if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(PlayerDao.class)
                    && checkDaoAnnotation(Factory.getPlayerDao().getClass())) {
                field.setAccessible(true);
                field.set(instance, Factory.getPlayerDao());
            }
        }
        return instance;
    }

    private static boolean checkDaoAnnotation(Class<?> clazz) throws NoDaoAnnotationException {
        if (clazz.getAnnotation(Dao.class) != null) {
            return true;
        }
        throw new NoDaoAnnotationException("No @Dao annotation at " + clazz.toString());
    }
}
