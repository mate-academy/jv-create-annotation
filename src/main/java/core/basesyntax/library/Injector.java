package core.basesyntax.library;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exceptions.NoSuchDaoImplementation;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchDaoImplementation {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Object init;

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class
                        && Factory.getBetDao().getClass().getAnnotation(Dao.class) != null) {
                    init = Factory.getBetDao();
                } else if (field.getType() == UserDao.class
                        && Factory.getUserDao().getClass().getAnnotation(Dao.class) != null) {
                    init = Factory.getUserDao();
                } else {
                    throw new NoSuchDaoImplementation("No such dao Implementation");
                }
                field.set(instance, init);
            }
        }
        return instance;
    }
}
