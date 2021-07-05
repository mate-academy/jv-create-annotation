package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.exeption.DaoModelNullException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz)
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, DaoModelNullException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field [] declaredField = clazz.getDeclaredFields();

        for (Field field: declaredField) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getType().equals(BetDao.class)
                        && Factory.getBetDao().getClass().getAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType().equals(PersonDao.class)
                        && Factory.getPersonDao().getClass().getAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getPersonDao());
                } else {
                    throw new DaoModelNullException("No implementation for this type");
                }

            }
        }
        return instance;

    }
}
