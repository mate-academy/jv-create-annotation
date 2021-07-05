package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.exceptions.NoSuchAnnotationException;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.PersonDaoFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchAnnotationException {

        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class
                        && BetDaoFactory
                        .getBetDao()
                        .getClass()
                        .isAnnotationPresent(Dao.class)) {
                    field.set(instance, BetDaoFactory.getBetDao());
                } else {
                    if (field.getType() == PersonDao.class
                            && PersonDaoFactory
                            .getPersonDao()
                            .getClass()
                            .isAnnotationPresent(Dao.class)) {
                        field.set(instance, PersonDaoFactory.getPersonDao());
                    } else {
                        throw new NoSuchAnnotationException("Can not find Dao annotation");
                    }
                }

            }
        }
        return instance;
    }
}
