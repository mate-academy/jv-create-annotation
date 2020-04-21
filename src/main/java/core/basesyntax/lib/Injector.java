package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImpl;
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
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<HumanDaoImpl> humanDaoImplClass = HumanDaoImpl.class;

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (betDaoImplClass.getAnnotation(Dao.class) != null
                        && field.getType().equals(BetDao.class)) {
                    field.set(instance, Factory.getBetDao());
                }
                if (humanDaoImplClass.getAnnotation(Dao.class) != null
                        && field.getType().equals(HumanDao.class)) {
                    field.set(instance, Factory.getHumanDao());
                }
            }
        }
        return instance;
    }
}
