package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.exception.NoImplementationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException,
            NoImplementationException {

        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Object daoObject;

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class
                        && Factory.getBetDao().getClass().getAnnotation(Dao.class) != null) {
                    daoObject = Factory.getBetDao();
                } else if (field.getType() == PersonDao.class
                        && Factory.getPersonDao().getClass().getAnnotation(Dao.class) != null) {
                    daoObject = Factory.getPersonDao();
                } else {
                    throw new NoImplementationException("No implementation for this type.");
                }
                field.set(instance, daoObject);
            }
        }
        return instance;
    }
}
