package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.OrderDao;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                field.setAccessible(true);
                field.set(instance, Factory.getBetDao());
            } else if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(OrderDao.class)) {
                field.setAccessible(true);
                field.set(instance, Factory.getOrderDao());
            }
        }
        return instance;
    }
}
