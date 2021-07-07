package core.basesyntax.library;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.exception.DaoNotSuchException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, DaoNotSuchException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class
                        && Factory.getBetDao().getClass().getAnnotation(Dao.class) != null) {
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType() == PersonDao.class
                        && Factory.getPersonDao().getClass().getAnnotation(Dao.class) != null) {
                    field.set(instance, Factory.getPersonDao());
                } else {
                    throw new DaoNotSuchException("Annotation Dao not found!");
                }
            }
        }
        return instance;
    }
}
