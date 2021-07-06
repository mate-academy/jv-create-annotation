package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.dao.PersonDaoImpl;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clszz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchDaoImplementationException {
        Constructor constructor = clszz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clszz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && BetDaoImpl.class.getAnnotation(Dao.class) != null) {
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType().equals(PersonDao.class)
                        && PersonDaoImpl.class.getAnnotation(Dao.class) != null) {
                    field.set(instance, Factory.getPersonDao());
                } else {
                    throw new NoSuchDaoImplementationException();
                }
            }
        }
        return instance;
    }
}
