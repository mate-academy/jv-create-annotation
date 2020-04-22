package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<UserDaoImpl> userDaoImplClass = UserDaoImpl.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (betDaoImplClass.getAnnotation(Dao.class) != null
                        && field.getType().equals(BetDao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                }
                if (userDaoImplClass.getAnnotation(Dao.class) != null
                        && field.getType().equals(UserDao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }
}

