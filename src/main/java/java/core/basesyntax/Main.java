package java.core.basesyntax;

import java.core.basesyntax.controller.ConsoleHandler;
import java.core.basesyntax.dao.BetDao;
import java.core.basesyntax.dao.BetDaoImpl;
import java.core.basesyntax.dao.ClientDao;
import java.core.basesyntax.dao.ClientDaoImpl;
import java.core.basesyntax.lib.Injector;

public class Main {
    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Если хотите сделать ставку, введите \n"
                + "имя, фамилию, сумму и риск через пробел");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        ClientDao clientDao = new ClientDaoImpl();
        System.out.println(betDao.getAll());
        System.out.println(clientDao.getAll());
    }
}
