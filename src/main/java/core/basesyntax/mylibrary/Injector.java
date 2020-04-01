package core.basesyntax.mylibrary;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImplantation;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.dao.PersonDaoImplantation;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.PersonDaoFactory;
import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Field[] consoleHandlerClassFields = consoleHandlerClass.getDeclaredFields();

        for (Field field: consoleHandlerClassFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (BetDaoImplantation.class.getDeclaredAnnotation(Dao.class) != null
                        && field.getType().equals(BetDao.class)) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                } else if (PersonDaoImplantation.class.getDeclaredAnnotation(Dao.class) != null
                        && field.getType().equals(PersonDao.class)) {
                    field.setAccessible(true);
                    field.set(null, PersonDaoFactory.getPersonDao());
                }
            }
        }
    }
}
