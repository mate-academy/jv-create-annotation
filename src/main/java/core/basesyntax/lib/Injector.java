package core.basesyntax.lib;

import core.basesyntax.controller.Controller;
import core.basesyntax.dao.RobotDaoImpl;
import core.basesyntax.factory.RobotDaoFactory;
import java.lang.reflect.Field;

public class Injector {

    public static void injectDaoDependency() throws IllegalAccessException {
        Class<Controller> controllerClass = Controller.class;
        Class<RobotDaoImpl> robotDaoClass = RobotDaoImpl.class;

        if (robotDaoClass.getDeclaredAnnotation(Dao.class) == null) {
            throw new IllegalArgumentException();
        }
        System.out.println("injecting dao in field");
        Field[] controllerFields = controllerClass.getDeclaredFields();
        for (Field field : controllerFields) {
            if (field.getDeclaredAnnotation(InjectDao.class) != null) {
                field.setAccessible(true);
                field.set(null, RobotDaoFactory.getRobotDao());
            }
        }
    }
}
