package core.basesyntax;

import controller.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.HumanDao;
import dao.HumanDaoImpl;
import lib.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Введите ставку или данные через пробел \n"
                        + "пример для вставки - bet 200 0.3"
                        + "пример для даных - human Name Surname \n");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        System.out.println(betDao.getAll());
        HumanDao humanDao = new HumanDaoImpl();
        System.out.println(humanDao.getAll());
    }
}
