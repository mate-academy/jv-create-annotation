package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.factory.Factory;
import core.basesyntax.factory.NoAnnotationException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class
                        && BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType() == UserDao.class
                        && UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getUserDao());
                } else {
                    throw new NoAnnotationException("There is an annotation absent");
                }
            }
        }
        return instance;
    }
}
