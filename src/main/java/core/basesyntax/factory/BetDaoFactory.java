package core.basesyntax.factory;

import core.basesyntax.dao.BetDaoImplantation;

public class BetDaoFactory {
    private static BetDaoImplantation instance;

    public static BetDaoImplantation getBetDao() {
        if (instance == null) {
            instance = new BetDaoImplantation();
        }
        return instance;
    }
}
