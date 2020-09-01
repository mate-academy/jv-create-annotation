package core.basesyntax.lib;

import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Field[] declaredFields = clazz.getDeclaredFields();
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.getAnnotation(Inject.class) != null) {
                field.set(instance, Factory.getBetDao());
            }
            if (field.getAnnotation(Dao.class) != null) {
                field.set(instance, Factory.getUserDao());
            }
        }
        return instance;
    }
}
