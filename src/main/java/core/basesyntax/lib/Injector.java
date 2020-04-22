package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.GamerDao;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        Field[] declaredFields = clazz.getDeclaredFields();
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Object dependency;

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && (Factory.getBetDao().getClass().getAnnotation(Dao.class) != null)) {
                    dependency = Factory.getBetDao();
                } else if (field.getType().equals(GamerDao.class)
                        && (Factory.getGamerDao().getClass().getAnnotation(Dao.class) != null)) {
                    dependency = Factory.getGamerDao();
                } else {
                    throw new RuntimeException("No have class whith Dao anotations");
                }
                field.set(instance, dependency);
            }
        }
        return instance;
    }
}
