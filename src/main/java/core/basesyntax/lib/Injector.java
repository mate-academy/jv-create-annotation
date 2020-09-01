package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exceptions.MissingAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class<?> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instant = constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getType().equals(BetDao.class)) {
                    if (Factory.getBetDao().getClass().getAnnotation(Dao.class) == null) {
                        throw new MissingAnnotationException("Dao annotation is missing "
                                + "in BetDaoImpl class");
                    }
                    field.setAccessible(true);
                    field.set(instant, Factory.getBetDao());
                }
                if (field.getType().equals(UserDao.class)) {
                    if (Factory.getUserDao().getClass().getAnnotation(Dao.class) == null) {
                        throw new MissingAnnotationException("Dao annotation is missing "
                                + "in UserDaoImpl class");
                    }
                    field.setAccessible(true);
                    field.set(instant, Factory.getUserDao());
                }
            }
        }
        return instant;
    }
}
