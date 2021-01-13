package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public ConsoleHandler(BetDao betDao, UserDao userDao) {
        this.betDao = betDao;
        this.userDao = userDao;
    }

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
                String[] data = command.split(" ");
                String userName = data[0];
                int userAge = Integer.parseInt(data[1]);
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                bet = new Bet(value, risk);
                user = new User(userName, userAge);

            } catch (NumberFormatException e) {
                System.out.println("Input correct data: name, age, bet, risk");
            }
            if (bet != null && user != null) {
                betDao.add(bet);
                userDao.add(user);
                System.out.println(user);
                System.out.println(bet);
            }
        }
    }
}
