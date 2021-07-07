package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.library.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void handleBets() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("q - for quit");
        System.out.println("Input value and risk for your bet:");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }

            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Input correct data, please. Waiting for numbers");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Input correct data, please. Waiting for two numbers");
            }

            if (bet != null) {
                betDao.add(bet);
                System.out.println(bet.toString());
            }
        }
    }

    public void handleUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();

        User user = new User(login, password);
        userDao.add(user);
    }
}
