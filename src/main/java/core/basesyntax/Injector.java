package core.basesyntax;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchImplementationException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object newInstance = declaredConstructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<UserDaoImpl> userDaoClass = UserDaoImpl.class;
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                field.setAccessible(true);
                if (betDaoClass.isAnnotationPresent(Dao.class)) {
                    field.set(newInstance, Factory.getBetDaoFactory());
                } else {
                    throw new NoSuchImplementationException("We don't have"
                            + " implementation of BetDao");
                }
            }
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(UserDao.class)) {
                field.setAccessible(true);
                if (userDaoClass.isAnnotationPresent(Dao.class)) {
                    field.set(newInstance, Factory.getUserDaoFactory());
                } else {
                    throw new NoSuchImplementationException("We don't have"
                            + " implementation of UserDao");
                }
            }
        }
        return newInstance;
    }
}
