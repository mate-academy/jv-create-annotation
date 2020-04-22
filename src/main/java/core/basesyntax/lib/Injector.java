package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.exception.NoAnnotationDao;
import core.basesyntax.facrory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoAnnotationDao {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class
                        && Factory.getBetDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType() == HumanDao.class
                        && Factory.getBetDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getHumanDao());
                } else {
                    throw new NoAnnotationDao();
                }
            }
        }
        return instance;
    }
}
