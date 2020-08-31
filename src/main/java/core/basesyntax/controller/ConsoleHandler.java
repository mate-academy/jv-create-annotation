package core.basesyntax.controller;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.Dao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private final Dao<Bet> betDao = new BetDaoImpl();
    private final Dao<User> userDao = new UserDaoImpl();
    private final Scanner scanner = new Scanner(System.in);

    public void handle() {
        handleUser();
        handleBet();
    }

    private void handleBet() {
        System.out.println("Please input your bet value and risk:");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            String[] betData = command.split(" ");
            Bet bet = null;
            try {
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Input correct information please!");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }

    private void handleUser() {
        System.out.println("Please input your name and age:");
        String input = scanner.nextLine();
        String[] userData = input.split(" ");
        User user = null;
        try {
            String name = userData[0];
            int age = Integer.parseInt(userData[1]);
            user = new User(name, age);
        } catch (NumberFormatException e) {
            System.out.println("Bad input data!");
            handleUser();
        }
        userDao.add(user);
    }
}
