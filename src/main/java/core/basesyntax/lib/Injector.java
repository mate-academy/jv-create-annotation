package core.basesyntax.lib;

import core.basesyntax.controller.Controller;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.RobotDao;
import core.basesyntax.dao.RobotDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.RobotDaoFactory;
import java.lang.reflect.Field;

public class Injector {

    public static void injectDaoDependency() throws IllegalAccessException {
        Class<Controller> controllerClass = Controller.class;
        Class<RobotDaoImpl> robotDaoClass = RobotDaoImpl.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;

        if (robotDaoClass.getDeclaredAnnotation(Dao.class) == null
                || betDaoClass.getDeclaredAnnotation(Dao.class) == null) {
            throw new IllegalArgumentException();
        }
        Field[] controllerFields = controllerClass.getDeclaredFields();
        for (Field field : controllerFields) {
            if (field.getDeclaredAnnotation(InjectDao.class) != null) {
                field.setAccessible(true);
                if (field.getType() == RobotDao.class) {
                    field.set(null, RobotDaoFactory.getRobotDao());
                }
                if (field.getType() == BetDao.class) {
                    field.set(null, BetDaoFactory.getBetDao());
                }
            }

        }
    }
}
