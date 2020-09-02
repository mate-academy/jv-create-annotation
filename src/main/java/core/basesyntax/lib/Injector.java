package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImp;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImp;
import core.basesyntax.exception.DaoAnnotationNotFound;
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
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(UserDao.class)) {
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }

    public static void checkDaoAnnotation() throws DaoAnnotationNotFound {
        Class<BetDaoImp> betDaoImp = BetDaoImp.class;
        if (!betDaoImp.isAnnotationPresent(Dao.class)) {
            throw new DaoAnnotationNotFound("BetDaoImp haven't @Dao annotation!");
        }
        Class<UserDaoImp> userDaoImpClass = UserDaoImp.class;
        if (!userDaoImpClass.isAnnotationPresent(Dao.class)) {
            throw new DaoAnnotationNotFound("UserDaoImp haven't @Dao annotation!");
        }
    }
}
