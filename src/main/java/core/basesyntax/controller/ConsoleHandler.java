package core.basesyntax.controller;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.dao.interfaces.BetDao;
import core.basesyntax.dao.interfaces.UserDao;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private BetDao betDao = new BetDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please, enter login and password for your bet!");
            String inputUser = scanner.nextLine();
            System.out.println("Please, enter value and risk for your bet!");
            String inputBet = scanner.nextLine();
            if (inputUser.equalsIgnoreCase("q") || inputBet.equalsIgnoreCase("q")) {
                break;
            }
            try {
                userDao.add(new User(inputBet.split(" ")[0],
                        inputBet.split(" ")[1]));
                betDao.add(new Bet(Integer.parseInt(inputBet.split(" ")[0]),
                        Double.parseDouble(inputBet.split(" ")[1])));
            } catch (NumberFormatException exception) {
                System.out.println("Please, enter valid data");
            }
        }
    }
}
