package core.basesyntax.controller;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.dao.interfaces.BetDao;
import core.basesyntax.dao.interfaces.UserDao;
import core.basesyntax.dao.Storage;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private BetDao betDao = new BetDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            try {
                betDao.add(new Bet(Integer.parseInt(input.split(" ")[0]),
                        Double.parseDouble(input.split(" ")[1])));
            } catch (NumberFormatException exception) {
                System.out.println("Please, enter valid data");
            }
        }

        System.out.println(Storage.bets.toString());
    }
}
