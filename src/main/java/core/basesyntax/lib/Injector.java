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
                field.set(instance, getDaoImpl(field.getType()));
            }
        }
        return instance;
    }

    private BaseDao getDaoImpl(Class<?> type) {
        BaseDao dao = null;
        if (type == BetDao.class) {
            dao = factory.getBetDao();
        }
        if (type == UserDao.class) {
            dao = factory.getUserDao();
        }

        if (dao != null && dao.getClass().getAnnotation(Dao.class) != null) {
            return dao;
        }
        throw new IllegalArgumentException("Dao implementation not found for " + type);
    }
}
