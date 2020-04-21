package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CatDao;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException {

        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)
                    && field.getName().equals("betDao")) {
                field.setAccessible(true);
                field.set(instance, Factory.getBetDao());
            }
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(CatDao.class)
                    && field.getName().equals("catDao")) {
                field.setAccessible(true);
                field.set(instance, Factory.getCatDao());
            }
        }
        return instance;
    }
}
