package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;

public interface DaoFactory {
    BetDao getBetDao();

    UserDao getUserDao();
}
