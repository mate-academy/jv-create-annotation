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

        if (betDaoClass.getAnnotation(Dao.class) == null
                || humanDaoClass.getAnnotation(Dao.class) == null) {
            throw new AnotationNoExistException("Анотація Dao відсутня");
        }
        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field: consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (field.getType() == BetDao.class) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                }
                if (field.getType() == HumanDao.class) {
                    field.setAccessible(true);
                    field.set(null, HumanDaoFactory.getHumanDao());
                }
            } else {
                throw new AnotationNoExistException("Анотація Inject відсутня");
            }
        }
    }
}
