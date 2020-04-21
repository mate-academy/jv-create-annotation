package core.basesyntax.lib;

import core.basesyntax.dao.BaseDao;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.DaoFactory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    private DaoFactory factory;

    public Injector(DaoFactory factory) {
        this.factory = factory;
    }

    public <T> T getInstance(Class<T> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                BaseDao dao = getDao(field.getType());
                if (dao.getClass().getAnnotation(Dao.class) != null) {
                    field.set(instance, dao);
                }
            }
        }
        return instance;
    }

    private BaseDao getDao(Class<?> type) {
        if (type == BetDao.class) {
            return factory.getBetDao();
        }
        if (type == UserDao.class) {
            return factory.getUserDao();
        }
        throw new IllegalArgumentException("Illegal Dao class " + type);
    }
}
