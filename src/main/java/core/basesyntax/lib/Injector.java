package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exeption.NoAnnotationFoundException;
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
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && betDaoImplClass.isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getBetDao());
                } else {
                    throw new NoAnnotationFoundException("Такої анотації не знайдено");
                }
                if (field.getType().equals(UserDao.class)
                        && userDaoImplClass.isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getUserDao());
                } else {
                    throw new NoAnnotationFoundException("Такої анотації не знайдено");
                }
            }
        }
        return instance;
    }
}
