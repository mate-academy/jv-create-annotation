package core.basesyntax.lib;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.factory.Factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public  static Object getInstance (Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredField = clazz.getDeclaredFields();

        for (Field field : declaredField) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(instance, Factory.getBetDao());
            }
        }
        return instance;
    }
}
