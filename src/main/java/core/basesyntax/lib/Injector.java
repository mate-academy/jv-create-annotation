package core.basesyntax.lib;

import core.basesyntax.dao.bet.BetDao;
import core.basesyntax.dao.bet.BetDaoImpl;
import core.basesyntax.dao.user.UserDao;
import core.basesyntax.dao.user.UserDaoImpl;
import core.basesyntax.exception.AnnotationDaoIsAbsentException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    private static final String EXCEPTION_MESSAGE = "Class %s doesn't have '@Dao' annotation";

    public static Object getInstance(Class clazz) throws IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException {

        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    if (BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                        field.set(instance, Factory.getBetDao());
                    } else {
                        throw new AnnotationDaoIsAbsentException(
                                String.format(EXCEPTION_MESSAGE, field.getType().getName()));
                    }
                }
                if (field.getType().equals(UserDao.class)) {
                    if (UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                        field.set(instance, Factory.getUserDao());
                    } else {
                        throw new AnnotationDaoIsAbsentException(
                                String.format(EXCEPTION_MESSAGE, field.getType().getName()));
                    }
                }
            }
        }
        return instance;
    }
}
