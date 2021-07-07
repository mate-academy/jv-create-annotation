package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exceptions.NoSuchAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();
        checkDaoAnnotation();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getType().equals(BetDao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(UserDao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getUserDao());
                }

            }
        }
        return instance;
    }

    private static void checkDaoAnnotation() {
        Class<? extends BetDao> betDaoImplClass = Factory.getBetDao().getClass();
        Class<? extends UserDao> userDaoImplClass = Factory.getUserDao().getClass();
        if (!(betDaoImplClass.isAnnotationPresent(Dao.class)
                && userDaoImplClass.isAnnotationPresent(Dao.class))) {
            throw new NoSuchAnnotationException("No dao annotation was found");
        }
    }

}
