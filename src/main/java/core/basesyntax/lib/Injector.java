package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CarDao;
import core.basesyntax.exception.NoAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && Factory.getBetDao().getClass().getAnnotation(Dao.class) != null) {
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType().equals(CarDao.class)
                        && Factory.getCarDao().getClass().getAnnotation(Dao.class) != null) {
                    field.set(instance, Factory.getCarDao());
                } else {
                    throw new NoAnnotationException(field.getName()
                            + " implementation has no @Dao annotation");
                }
            }
        }
        return instance;
    }
}
