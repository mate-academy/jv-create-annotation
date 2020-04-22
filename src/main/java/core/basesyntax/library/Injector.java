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
            InstantiationException, NoAnnotationException {

        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] classFields = clazz.getDeclaredFields();

        for (Field field : classFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (field.getDeclaredAnnotation(Inject.class) != null) {
                    if (field.getType().equals(BetDao.class)
                            && BetDaoImpl.class.getAnnotation(Dao.class) != null) {
                        field.setAccessible(true);
                        field.set(instance, Factory.getBetDao());
                    } else if (field.getType().equals(UserDao.class)
                            && UserDaoImpl.class.getAnnotation(Dao.class) != null) {
                        field.setAccessible(true);
                        field.set(instance, Factory.getUserDao());
                    } else{
                        throw new NoAnnotationException("No Dao implementation "
                                + "in implemented classes");
                    }
                }
            }
        }
        return instance;
    }
}
