package core.basesyntax.factory;

import core.basesyntax.dao.BarvinokDao;
import core.basesyntax.dao.BarvinokDaoImpl;

public class RequestBarvinokDaoFactory {

    public static BarvinokDao barvinikInstanse;

    public static BarvinokDao getRequesBarvinokDao() {
        if (barvinikInstanse == null) {
            barvinikInstanse = new BarvinokDaoImpl();
        }
        return barvinikInstanse;
    }
}


