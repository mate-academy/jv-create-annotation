package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CarDao;
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
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(CarDao.class)) {
                    field.set(instance, Factory.getCarDao());
                }
            }
        }
        return instance;
    }
}
