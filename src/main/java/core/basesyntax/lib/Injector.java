package core.basesyntax.lib;

import core.basesyntax.DAO.BetDao;
import core.basesyntax.DAO.BetDaoImpl;
import core.basesyntax.DAO.CasinoDAO;
import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.factory.BetDAOFactory;
import core.basesyntax.factory.CasinoDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;

        Field[] fields = consoleHandlerClass.getDeclaredFields();
        for(Field field : fields){
            if(field.getDeclaredAnnotation(Inject.class) != null && field.getType().equals(BetDao.class)){
                field.setAccessible(true);
                field.set(null, BetDAOFactory.getBetDAO());
            }
            if(field.getDeclaredAnnotation(Inject.class) != null && field.getType().equals(CasinoDAO.class)){
                field.setAccessible(true);
                field.set(null, CasinoDaoFactory.getCasinoDao());
            }
        }
    }
}
