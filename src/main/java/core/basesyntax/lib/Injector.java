package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.NoSuchImplementationException;
import core.basesyntax.facotry.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getConstructor();
        Object instance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && Factory.getBetDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType().equals(UserDao.class)
                        && Factory.getUserDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getUserDao());
                } else {
                    throw new NoSuchImplementationException("We don't have"
                            + " necessary implementation");
                }
            }
        }
        return instance;
    }
}
