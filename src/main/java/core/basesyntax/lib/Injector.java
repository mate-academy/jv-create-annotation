package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImpl;
import core.basesyntax.exceptions.NoInjectException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoInjectException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && BetDaoImpl.class.getAnnotation(Dao.class) != null) {
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(HumanDao.class)
                        && HumanDaoImpl.class.getAnnotation(Dao.class) != null) {
                    field.set(instance, Factory.getHumanDao());
                }
            } else {
                throw new NoInjectException("You can't initialise the fields "
                        + "of this class(Inject annotation is absent)");
            }
        }
        return instance;
    }
}