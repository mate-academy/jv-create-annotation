package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PersonDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.PersonDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void  injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<PersonDaoImpl> personDaoImplClass = PersonDaoImpl.class;
        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (betDaoImplClass.getDeclaredAnnotation(Dao.class) != null
                        || personDaoImplClass.getDeclaredAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    if (field.getType() == BetDao.class) {
                        field.set(null, BetDaoFactory.getBetDao());
                    } else {
                        field.set(null, PersonDaoFactory.getPersonDao());
                    }
                }
            }
        }
    }
}
