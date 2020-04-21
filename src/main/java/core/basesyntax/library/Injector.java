package core.basesyntax.library;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException, NoDaoAnnotationException {

        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] classFields = clazz.getDeclaredFields();

        for (Field field : classFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (BetDaoImpl.class.getAnnotation(Dao.class) == null
                        || UserDaoImpl.class.getAnnotation(Dao.class) == null) {
                    throw new NoDaoAnnotationException("No Dao implementation "
                            + "in implemented classes");
                }
                if (field.getType().equals(BetDao.class)
                        && BetDaoImpl.class.getAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(UserDao.class)
                        && UserDaoImpl.class.getAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }
}
