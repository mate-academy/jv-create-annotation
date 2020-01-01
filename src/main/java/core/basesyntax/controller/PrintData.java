package core.basesyntax.controller;

import static core.basesyntax.controller.ConsoleHandler.betDao;
import static core.basesyntax.controller.ConsoleHandler.userDao;

public class PrintData {
    public static void print() {
        for (int i = 0; i < userDao.getAll().size(); i++) {
            System.out.println(userDao.get(i) + " " + betDao.get(i));
        }
    }
}
