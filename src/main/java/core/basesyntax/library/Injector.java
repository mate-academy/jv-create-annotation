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
    public static Object getInstance(Class clazs) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor constructor = clazs.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredFields = clazs.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {

                field.setAccessible(true);

                if (field.getType() == BetDao.class) {
                    if (!BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                        throw new RuntimeException("Annotation @Dao is absent for BetDaoImpl");
                    }
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType() == UserDao.class) {
                    if (!UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                        throw new RuntimeException("Annotation @Dao is absent for UserDaoImpl");
                    }
                    field.set(instance, Factory.getUserDao());
                } else {
                    throw new RuntimeException("Unsupported type ["
                            + field.getType().getName() + "]");
                }
            }
        }
        return instance;
    }
}
