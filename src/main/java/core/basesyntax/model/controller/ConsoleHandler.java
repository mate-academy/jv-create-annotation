package core.basesyntax.model.controller;

import core.basesyntax.model.dao.BetDao;
import core.basesyntax.model.dao.BetDaoImpl;
import core.basesyntax.model.dao.UserDao;
import core.basesyntax.model.dao.UserDaoImpl;
import core.basesyntax.model.model.Bet;
import core.basesyntax.model.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private BetDao betDao = new BetDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("q")) {
                return;
            }

            Bet bet = null;
            User user = null;

            try {
                String[] inputData = command.split(" ");
                int value = Integer.parseInt(inputData[0]);
                double risk = Double.parseDouble(inputData[1]);
                String login = inputData[2];
                String password = inputData[3];
                bet = new Bet(value, risk);
                user = new User(login, password, bet);
            } catch (NumberFormatException e) {
                System.out.println("Please, enter the correct information.");
            }

            betDao.add(bet);
            userDao.add(user);
            System.out.println(user == null ? null : user.toString());
        }
    }
}
