package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;

public class Factory {
    private static class BetDaoHolder {
        private static BetDao betDao = new BetDaoImpl();
    }

    private static class UserDaoHolder {
        private static UserDao userDao = new UserDaoImpl();
    }

    public BetDao getBetDao() {
        return BetDaoHolder.betDao;
    }

    public UserDao getUserDao() {
        return UserDaoHolder.userDao;
    }
}
