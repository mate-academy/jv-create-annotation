import static core.basesyntax.lib.Injector.getInstance;

import core.basesyntax.controler.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.exception.NoAnnotationDao;
import core.basesyntax.facrory.Factory;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException, NoAnnotationDao {
        ConsoleHandler consoleHandler = (ConsoleHandler) getInstance(ConsoleHandler.class);
        System.out.println("Введіть дані в такому порядку: ставка, риск, імя, вік");
        consoleHandler.handle();
        BetDao betDao = Factory.getBetDao();
        HumanDao humanDao = Factory.getHumanDao();
        System.out.println("Всі ставки: " + betDao.getAll());
        System.out.println("Всі гравці: " + humanDao.getAll());
    }
}
