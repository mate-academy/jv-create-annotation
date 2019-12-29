package core.basesyntax;

import controller.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.HumanDao;
import dao.HumanDaoIml;
import lib.Injector;

public class Main {

    static {
        try {
            Injector.InjectDependency();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter your name, age and bet value, risk with whitespace " +
                "name age value risk" +
                "\nor \"0\" if you want exit: \n -> ");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        HumanDao humanDao = new HumanDaoIml();
        System.out.println(betDao.getAll());
        System.out.println(humanDao.getAll());
    }
}
