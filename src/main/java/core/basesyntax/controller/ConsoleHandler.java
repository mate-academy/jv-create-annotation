package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    UserDao userDao;
    @Inject
    BetDao betDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            User user = null;
            Bet bet = null;
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")) {
                System.out.println("That's all, folks...");
                return;
            }
            String[] credentials = userInput.split(" ");
            try {
                String userName = credentials[0];
                int userId = Integer.parseInt(credentials[1]);
                int value = Integer.parseInt(credentials[2]);
                double risk = Double.parseDouble(credentials[3]);
                user = new User(userName, userId);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Your input is incorrect, try again. To quit, enter 'q'");

            }
            userDao.add(user);
            betDao.add(bet);
            System.out.println(user == null ? "null" : user.toString());
            System.out.println(bet == null ? "null" : bet.toString());
        }
    }
}
