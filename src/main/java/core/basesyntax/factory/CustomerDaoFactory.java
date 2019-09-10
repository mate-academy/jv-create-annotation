package core.basesyntax.factory;

import core.basesyntax.dao.CustomerDao;
import core.basesyntax.dao.CustomerDaoImpl;

public class CustomerDaoFactory {

    public static CustomerDao instance;

    public static CustomerDao getLibrary() {
        if(instance == null) {
            instance = new CustomerDaoImpl();
        }
        return instance;
    }
}
