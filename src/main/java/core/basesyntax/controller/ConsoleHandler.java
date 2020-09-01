package core.basesyntax.controller;

import core.basesyntax.dao.UniversalDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final Scanner scanner = new Scanner(System.in);
    @Inject
    private UniversalDao<Bet> betUniversalDao;
    @Inject
    private UniversalDao<User> userUniversalDao;

    public void handle() {
        handleUser();
        handleBet();
    }

    private void handleBet() {
        while (true) {
            System.out.println("Please input your bet value and risk:");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            String[] betData = command.split(" ");
            checkInput(betData);
            Bet bet;
            try {
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Bad input information!");
                continue;
            }
            betUniversalDao.add(bet);
            System.out.println(bet.toString());
        }
    }

    private void handleUser() {
        System.out.println("Please input your name and age:");
        String input = scanner.nextLine();
        String[] userData = input.split(" ");
        checkInput(userData);
        User user = null;
        try {
            String name = userData[0];
            int age = Integer.parseInt(userData[1]);
            user = new User(name, age);
        } catch (NumberFormatException e) {
            System.out.println("Bad input data!");
            handleUser();
        }
        userUniversalDao.add(user);
    }

    private void checkInput(String[] input) {
        if (input.length != 2) {
            throw new IllegalArgumentException("All of fields can't be null!");
        }
    }
}
