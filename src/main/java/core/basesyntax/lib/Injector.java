package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImpl;
import core.basesyntax.exceptions.NoAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoAnnotationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] instanceFields = clazz.getDeclaredFields();
        for (Field field : instanceFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && BetDaoImpl.class.getAnnotation(Dao.class) != null) {
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(PlayerDao.class)
                        && PlayerDaoImpl.class.getAnnotation(Dao.class) != null) {
                    field.set(instance, Factory.getPlayerDao());
                }
            }
        }
        return instance;
    }
}
