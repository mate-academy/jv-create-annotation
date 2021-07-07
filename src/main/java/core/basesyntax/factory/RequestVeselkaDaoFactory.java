package core.basesyntax.factory;

import core.basesyntax.dao.RequestVeselkaDao;
import core.basesyntax.dao.RequestVeselkaDaoImpl;

public class RequestVeselkaDaoFactory {

    public static RequestVeselkaDao INSTASE;

    public static RequestVeselkaDao getRequestVeselkaDao() {
        if (INSTASE == null) {
            INSTASE = new RequestVeselkaDaoImpl();
        }
        return INSTASE;
    }
}
