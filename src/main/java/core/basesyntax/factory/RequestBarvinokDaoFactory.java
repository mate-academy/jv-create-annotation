package core.basesyntax.factory;

import core.basesyntax.dao.RequestVeselkaDao;
import core.basesyntax.dao.RequestVeselkaDaoImpl;

public class RequestBarvinokDaoFactory {

    public static RequestVeselkaDao INSTASE;

    public static RequestVeselkaDao getRequesBarvinokDao() {
        if (INSTASE == null) {
            INSTASE = new RequestVeselkaDaoImpl();
        }
        return INSTASE;
    }
}


