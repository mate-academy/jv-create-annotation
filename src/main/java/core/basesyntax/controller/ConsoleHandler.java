package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final int NAME_INDEX = 0;
    private static final int SURNAME_INDEX = 1;
    private static final int AGE_INDEX = 2;
    private static final int VALUE_INDEX = 3;
    private static final int RISK_INDEX = 4;

    @Inject
    private BetDao betDao;

    @Inject
    private UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                System.out.println(userDao.getAllUsers());
                System.out.println(betDao.getAllBets());
                return;
            }
            Bet bet;
            User user;
            try {
                String[] betData = command.split(" ");
                String name = betData[NAME_INDEX];
                String surname = betData[SURNAME_INDEX];
                int age = Integer.parseInt(betData[AGE_INDEX]);
                if (age < 18) {
                    throw new IllegalArgumentException("You are to young to do bets");
                }
                int value = Integer.parseInt(betData[VALUE_INDEX]);
                double risk = Double.parseDouble(betData[RISK_INDEX]);
                bet = new Bet(value, risk);
                user = new User(name, surname, age);
                betDao.add(bet);
                userDao.add(user);
            } catch (NumberFormatException e) {
                System.out.println("You have entered unparsable data. "
                        + "Try again or enter 'q' to quit");
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("You've entered too little information. "
                        + "Try again or enter 'q' to quit");
                continue;
            }
            System.out.println(bet.toString() + " " + user.toString());
            System.out.println("Keep betting or enter 'q' to quit");
        }
    }
}
