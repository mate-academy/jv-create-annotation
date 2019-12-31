package core.basesyntax.lib;

import core.basesyntax.controllers.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImpl;
import core.basesyntax.exceptions.AnotationNoExistException;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.HumanDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException, AnotationNoExistException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<HumanDaoImpl> humanDaoClass = HumanDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field: consoleHandlerFields) {
            if (field.getType() == BetDao.class) {
                if (field.getDeclaredAnnotation(Inject.class) != null
                        && betDaoClass.getAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                } else {
                    throw new AnotationNoExistException("Анотація відсутня");
                }
            }

            if (field.getType() == HumanDao.class) {
                if (field.getDeclaredAnnotation(Inject.class) != null
                        && humanDaoClass.getAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(null, HumanDaoFactory.getHumanDao());
                } else {
                    throw new AnotationNoExistException("Анотація відсутня");
                }
            }
        }
    }
}
