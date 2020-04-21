package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.HumanDaoFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<HumanDaoImpl> humanDaoClass = HumanDaoImpl.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (humanDaoClass.getAnnotation(Dao.class) != null
                        && field.getType().equals(HumanDao.class)) {
                    field.setAccessible(true);
                    field.set(instance, HumanDaoFactory.getHumanDao());
                }
                if (betDaoClass.getAnnotation(Dao.class) != null
                        && field.getType().equals(BetDao.class)) {
                    field.setAccessible(true);
                    field.set(instance, BetDaoFactory.getBetDao());
                }
            }
        }
        return instance;
    }
}
