package core.basesyntax.lib;

import core.basesyntax.dao.BetDaoImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class DaoClass {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Dao.class) != null) {
                field.setAccessible(true);
                field.set(instance, new BetDaoImpl());
            }
        }
        return instance;
    }
}

