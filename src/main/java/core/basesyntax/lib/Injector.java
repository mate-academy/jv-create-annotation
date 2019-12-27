package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.CasinoDao;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.CasinoDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;

        Field[] fields = consoleHandlerClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(CasinoDao.class)) {
                field.setAccessible(true);
                field.set(null, CasinoDaoFactory.getCasinoDao());
            }
        }
    }
}
