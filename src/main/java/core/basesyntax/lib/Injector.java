package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.DaoAnnotationException;
import core.basesyntax.dao.UserDao;
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
            if (field.getAnnotation(Inject.class) != null && field.getType().equals(BetDao.class)) {
                field.setAccessible(true);
                field.set(instance, Factory.getBetDao());
            }
            if (field.getAnnotation(Inject.class) != null && field.getType().equals(UserDao.class)) {
                field.setAccessible(true);
                field.set(instance, Factory.getUserDao());
            }
            if (Factory.getUserDao().getClass().getAnnotation(Dao.class) == null
                    || Factory.getBetDao().getClass().getAnnotation(Dao.class) == null) {
                throw new DaoAnnotationException("There is no proper annotation "
                        + "in Dao implementation class");
            }
        }
        return instance;
    }
}
