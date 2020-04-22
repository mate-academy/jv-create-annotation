package core.basesyntax.lib;

import core.basesyntax.Exception.NoDaoImplException;
import core.basesyntax.Factory.Factory;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, NoDaoImplException {
        Constructor constructor = clazz.getDeclaredConstructor();

        Object instance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        Object initializer;

        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class
                        && Factory.getBetDao().getClass().getAnnotation(Dao.class) != null) {
                    initializer = Factory.getBetDao();
                } else if (field.getType() == UserDao.class
                        && Factory.getUserDao().getClass().getAnnotation(Dao.class) != null) {
                    initializer = Factory.getUserDao();
                } else {
                    throw new NoDaoImplException("No implementation for this type");
                }
                field.set(instance, initializer);
            }
        }
        return instance;
    }
}
