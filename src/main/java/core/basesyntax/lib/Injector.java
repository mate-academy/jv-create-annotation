package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.CarDao;
import core.basesyntax.dao.CarDaoImpl;
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
                if (field.getType().equals(BetDao.class)) {
                    if (BetDaoImpl.class.getAnnotation(Dao.class) == null) {
                        throw new NoAnnotationException("BetDaoImpl class has no @Dao annotation");
                    }
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(CarDao.class)) {
                    if (CarDaoImpl.class.getAnnotation(Dao.class) == null) {
                        throw new NoAnnotationException("CarDaoImpl class has no @Dao annotation");
                    }
                    field.set(instance, Factory.getCarDao());
                }
            }
        }
        return instance;
    }
}
