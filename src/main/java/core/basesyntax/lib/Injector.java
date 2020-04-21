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
        Class<UserDaoImpl> userDaoImplClass = UserDaoImpl.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (userDaoImplClass.getAnnotation(Dao.class) != null
                        && field.getType().equals(UserDao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getUserDao());
                }
                if (betDaoImplClass.getAnnotation(Dao.class) != null
                        && field.getType().equals(BetDao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                }
            }
        }
        return instance;
    }
}
