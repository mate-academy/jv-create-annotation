package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exceptions.NoSuchImplementationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchImplementationException {

        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Object daoObject;

        Field[] declareFields = clazz.getDeclaredFields();

        for (Field field: declareFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class
                        && Factory.getBetDao().getClass().getAnnotation(Dao.class) != null) {
                    daoObject = Factory.getBetDao();
                } else if (field.getType() == UserDao.class && Factory.getUserDao().getClass()
                        .getAnnotation(Dao.class) != null) {
                    daoObject = Factory.getUserDao();
                } else {
                    throw new NoSuchImplementationException(
                            "Implementation for this type not found!");
                }
                field.set(instance, daoObject);
            }
        }
        return instance;
    }
}
