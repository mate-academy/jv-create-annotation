package java.core.basesyntax.factory;

import java.core.basesyntax.dao.ClientDao;
import java.core.basesyntax.dao.ClientDaoImpl;

public class ClientDaoFactory {

    private static ClientDao instance;

    public static ClientDao getClientDao() {
        if (instance == null) {
            instance = new ClientDaoImpl();
        }
        return instance;
    }
}
