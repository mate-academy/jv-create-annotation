package core.basesyntax.library;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.exceptions.NoSuchDaoException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchDaoException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getType().equals(BetDao.class)
                        && Factory.getBetDao().getClass().getAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                    continue;
                }
                if (field.getType().equals(PlayerDao.class)
                        && Factory.getPlayerDao().getClass().getAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getPlayerDao());
                    continue;
                }
                throw new NoSuchDaoException("No such Dao Implementation");
            }
        }
        return instance;
    }
}
