package core.basesyntax.lib;

import core.basesyntax.factory.Factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws IllegalAccessException
            , InvocationTargetException, InstantiationException, NoSuchMethodException {

        Constructor constructor = clazz.getConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getName().equalsIgnoreCase("betDao")
                    && Factory.getBetDao().getClass().isAnnotationPresent(Dao.class)) {
                field.setAccessible(true);
                field.set(instance, Factory.getBetDao());
            } else if (field.getAnnotation(Inject.class) != null
                    && field.getName().equalsIgnoreCase("playerDao")) {
                field.setAccessible(true);
                field.set(instance, Factory.getPlayerDao());
            }
        }
        return instance;
    }
}
