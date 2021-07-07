package core.basesyntax.facrory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImpl;

public class Factory {
    public static BetDao betDao;
    public static HumanDao humanDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static HumanDao getHumanDao() {
        if (humanDao == null) {
            humanDao = new HumanDaoImpl();
        }
        return humanDao;
    }
}
