package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.exception.AnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class<?> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                Object dao = new Object();
                if (field.getType() == BetDao.class) {
                    dao = Factory.getBetDao();
                } else if (field.getType() == PlayerDao.class) {
                    dao = Factory.getPlayerDao();
                }
                if (dao.getClass().getAnnotation(Dao.class) == null) {
                    throw new AnnotationException("This type of class doesn't have "
                            + "@Dao annotation");
                } else {
                    field.set(instance, dao);
                }
            }
        }
        return instance;
    }
}
