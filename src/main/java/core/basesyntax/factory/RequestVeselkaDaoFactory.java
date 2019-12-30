package core.basesyntax.factory;

import core.basesyntax.dao.VeselkaDao;
import core.basesyntax.dao.VeselkaDaoImpl;

public class RequestVeselkaDaoFactory {

    public static VeselkaDao veselkaInstanse;

    public static VeselkaDao getRequestVeselkaDao() {
        if (veselkaInstanse == null) {
            veselkaInstanse = new VeselkaDaoImpl();
        }
        return veselkaInstanse;
    }
}
