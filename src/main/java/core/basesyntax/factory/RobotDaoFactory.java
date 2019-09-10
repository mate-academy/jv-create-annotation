package core.basesyntax.factory;

import core.basesyntax.dao.RobotDao;
import core.basesyntax.dao.RobotDaoImpl;

public class RobotDaoFactory {
    private static RobotDao instance;

    public static RobotDao getRobotDao() {
        if (instance == null) {
            instance = new RobotDaoImpl();
        }
        return instance;
    }
}
