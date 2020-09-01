package core.basesyntax.library;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exception.MissingAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    if (BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                        field.set(instance, Factory.getBetDao());
                    } else {
                        throw new MissingAnnotationException("Missing DAO annotation");
                    }
                }
                if (field.getType().equals(UserDao.class)) {
                    if (UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                        field.set(instance, Factory.getUserDao());
                    } else {
                        throw new MissingAnnotationException("Missing DAO annotation");
                    }
                }
            }
        }
        return instance;
    }
}
