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
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getType().equals(BetDao.class)
                        && betDaoClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(newInstance, Factory.getBetDao());
                } else if (field.getType().equals(UserDao.class)
                        && userDaoClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(newInstance, Factory.getUserDao());
                } else {
                    throw new NoSuchImplementationException("We don't have"
                            + " necessary implementation");
                }
            }
        }
        return newInstance;
    }
}
