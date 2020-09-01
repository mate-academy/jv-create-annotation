package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    BetDao betDao;

    @Inject
    UserDao userDao;

    public void handleBet() {
        System.out.println("Enter 'value' and 'risk' for your bet");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
                System.out.println(bet);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please, enter correct data or press 'q' to exit");
            }
        }
    }

    public void handleUser() {
        System.out.println("Enter your 'age' and 'name', 'password' for your account.\n"
                + "* Age should contains numbers only.\n"
                + "* Name must be at least 3 characters long, and password 8 characters.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] userData = command.split(" ");
                int age = Integer.parseInt(userData[0]);
                String name = userData[1];
                String password = userData[2];
                if (age <= 0 || name.length() < 3 || password.length() < 8) {
                    System.out.println("Please, enter correct data or press 'q' to exit");
                    continue;
                }
                User user = new User(age, name, password);
                userDao.add(user);
                System.out.println(user);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please, enter correct data or press 'q' to exit");
            }
        }
    }
}
