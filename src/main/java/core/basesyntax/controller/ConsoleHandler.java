package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betUniversalDao;
    @Inject
    private UserDao userUniversalDao;

    public void handle() {
        handleUser();
        handleBet();
    }

    private void handleBet() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please input your bet value and risk:");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            String[] betData = command.split(" ");
            Bet bet;
            try {
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Bad input information!");
                continue;
            }
            betUniversalDao.add(bet);
            System.out.println(bet.toString());
        }
    }

    private void handleUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please input your name and age:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }
            String[] userData = input.split(" ");
            User user;
            try {
                String name = userData[0];
                int age = Integer.parseInt(userData[1]);
                user = new User(name, age);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Bad input data!");
                continue;
            }
            userUniversalDao.add(user);
            System.out.println(user.toString());
        }
    }
}
