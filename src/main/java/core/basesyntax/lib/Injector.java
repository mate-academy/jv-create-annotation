package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.dao.PersonDaoImpl;
import core.basesyntax.exception.NoDaoImplementationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    private Injector() {
    }

    public static Object getInstance(Class clazz) throws IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException,
            NoDaoImplementationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getType().equals(BetDao.class)
                        && BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType().equals(PersonDao.class)
                        && PersonDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getPersonDao());
                } else {
                    throw new NoDaoImplementationException(
                            "None class implements Dao");
                }
            }
        }
        return instance;
    }
}
