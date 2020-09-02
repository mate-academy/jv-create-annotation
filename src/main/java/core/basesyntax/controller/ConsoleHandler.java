package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.library.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String EXIT_CASE = "exit";
    private static final String PARSE_REGEX = ", ";
    private static final int NAME_INDEX = 0;
    private static final int SURNAME_INDEX = 1;
    private static final int AGE_INDEX = 2;
    private static final int VALUE_INDEX = 3;
    private static final int RISK_INDEX = 4;
    private static final int AGE_FROM = 18;
    private static final int AGE_TO = 70;

    @Inject
    private BetDao betDao;

    @Inject
    private UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(EXIT_CASE)) {
                System.out.println(userDao.getAllUsers());
                System.out.println(betDao.getAllBets());
                return;
            }
            String[] parsedData;
            try {
                parsedData = command.split(PARSE_REGEX);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please, make sure your input data is valid and try again");
                continue;
            }
            int age = Integer.parseInt(parsedData[AGE_INDEX]);
            ageCheck(age);
            Bet bet;
            int value = Integer.parseInt(parsedData[VALUE_INDEX]);
            double risk = Double.parseDouble(parsedData[RISK_INDEX]);
            bet = new Bet(value, risk);
            betDao.add(bet);
            User user;
            String name = parsedData[NAME_INDEX];
            String surname = parsedData[SURNAME_INDEX];
            user = new User(name, surname, age);
            userDao.add(user);
            System.out.println(user.toString() + " - " + bet.toString());
            System.out.println("The bet is successfully created. For quiting type \"exit\"");
        }
    }

    private void ageCheck(int age) {
        if (age < AGE_FROM) {
            throw new IllegalArgumentException("You are too young to do bets");
        }
        if (age >= AGE_TO) {
            throw new IllegalArgumentException("You are too old to do bets");
        }
    }
}
