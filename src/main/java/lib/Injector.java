package lib;

import dao.BetDao;
import dao.PersonDao;
import exception.DaoNotExistsException;
import factory.BetFactory;
import factory.PersonFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws IllegalAccessException,
            InvocationTargetException, InstantiationException,
            NoSuchMethodException, DaoNotExistsException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class
                        && BetFactory
                        .getBetDao()
                        .getClass()
                        .isAnnotationPresent(Dao.class)) {
                    field.set(instance, BetFactory.getBetDao());
                } else {
                    if (field.getType() == PersonDao.class
                            && PersonFactory
                            .getPersonDao()
                            .getClass()
                            .isAnnotationPresent(Dao.class)) {
                        field.set(instance, PersonFactory.getPersonDao());
                    } else {
                        throw new DaoNotExistsException("Dao exception");
                    }
                }
            }
        }
        return instance;
    }
}
