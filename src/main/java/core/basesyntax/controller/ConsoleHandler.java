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

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            User user = null;
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                String login = betData[0];
                String password = betData[1];
                int amount = Integer.parseInt(betData[2]);
                double risk = Double.parseDouble(betData[3]);
                user = new User(login, password);
                bet = new Bet(amount, risk);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please enter the numbers in an appropriate format.");
                continue;
            }
            if (user != null && bet != null) {
                userDao.add(user);
                betDao.add(bet);
                System.out.println(user);
                System.out.println((bet));
            }
        }
    }
}
