import core.basesyntax.controler.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImpl;
import core.basesyntax.facrory.Factory;

import java.lang.reflect.InvocationTargetException;

import static core.basesyntax.lib.Injector.getInstance;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler consoleHandler = (ConsoleHandler) getInstance(ConsoleHandler.class);
        System.out.println("Введіть дані (ставка, риск, імя, вік)");
        consoleHandler.handle();
        BetDao betDao = Factory.getBetDao();
        HumanDao humanDao = new HumanDaoImpl();
        System.out.println("Всі ставки: " + betDao.getAll());
        System.out.println("Всі гравці: " + humanDao.getAll());
    }
}
