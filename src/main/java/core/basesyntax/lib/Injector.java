package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.NoSuchInjectionObjectException;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.UserDaoFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(UserDao.class)
                        && UserDaoFactory.getInstance().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, UserDaoFactory.getInstance());
                } else if (field.getType().equals(BetDao.class)
                        && BetDaoFactory.getInstance().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, BetDaoFactory.getInstance());
                } else {
                    throw new NoSuchInjectionObjectException("The required injection "
                            + "object was not found");
                }
            }
        }
        return instance;
    }
}
