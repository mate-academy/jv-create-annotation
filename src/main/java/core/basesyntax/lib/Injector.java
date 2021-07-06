package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.CasinoDao;
import core.basesyntax.dao.CasinoDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.CasinoDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {

        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<CasinoDaoImpl> casinoDaoClass = CasinoDaoImpl.class;
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Field[] fields = consoleHandlerClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                if (betDaoClass.getDeclaredAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                } else {
                    System.err.println("Wrong DAO format");
                }
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(CasinoDao.class)) {
                if (casinoDaoClass.getDeclaredAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(null, CasinoDaoFactory.getCasinoDao());
                } else {
                    System.err.println("Wrong DAO format");
                }
            }
        }
    }
}
