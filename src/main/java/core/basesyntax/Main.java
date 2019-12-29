package core.basesyntax;

import controller.ConsoleHandler;
import dao.betDao;
import dao.betDaoImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        System.out.print("Enter value and risk with whitespace: \n -> ");
        ConsoleHandler.handle();
        betDao betDao = new betDaoImpl();
        System.out.println(betDao.getAll());
    }
}
