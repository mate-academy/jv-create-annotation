package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws AbsentDaoAnnotationException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchMethodException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == UserDao.class && Factory
                        .getUserDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getUserDao());
                } else if (field.getType() == BetDao.class && Factory
                        .getBetDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getBetDao());
                } else {
                    throw new AbsentDaoAnnotationException("Dao annotation is absent.");
                }
            }
        }
        return instance;
    }
}
