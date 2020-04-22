package core.basesyntax.factory;

import core.basesyntax.dao.ClientDao;
import core.basesyntax.dao.ClientDaoImpl;
import core.basesyntax.dao.CreditDao;
import core.basesyntax.dao.CreditDaoImpl;

public class Factory {
    private static CreditDao creditDao;
    private static ClientDao clientDao;

    public static CreditDao getCreditDao() {
        if (creditDao == null) {
            creditDao = new CreditDaoImpl();
        }
        return creditDao;
    }

    public static ClientDao getClientDao() {
        if (clientDao == null) {
            clientDao = new ClientDaoImpl();
        }
        return clientDao;
    }
}
