package core.basesyntax.factory;

import core.basesyntax.dao.BaseDao;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;

public class Factory implements DaoFactory {
    public BetDao getBetDao() {
        return BetDaoImpl.getInstance();
    }

    public UserDao getUserDao() {
        return UserDaoImpl.getInstance();
    }

    public BaseDao getDao(Class<?> type) {
        if (type == BetDao.class) {
            return getBetDao();
        }
        if (type == UserDao.class) {
            return getUserDao();
        }
        throw new IllegalArgumentException("Illegal Dao class " + type);
    }
}
