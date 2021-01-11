package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String EXIT_COMMAND = "q";
    private static final String SEPARATOR = " ";
    private static final int BET_VALUE_INDEX = 0;
    private static final int BET_RISK_INDEX = 1;
    private static final int USER_NAME_INDEX = 2;
    private static final int USER_AGE_INDEX = 3;
    private BetDao betDao;
    private UserDao userDao;

    public ConsoleHandler(BetDao betDao, UserDao userDao) {
        this.betDao = betDao;
        this.userDao = userDao;
    }

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your data in following format:\n"
                + "bet_value" + SEPARATOR
                + "risk" + SEPARATOR
                + "user_name" + SEPARATOR
                + "user_age");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(EXIT_COMMAND)) {
                return;
            }
            try {
                String[] betData = command.split(SEPARATOR);

                int value = Integer.parseInt(betData[BET_VALUE_INDEX]);
                double risk = Double.parseDouble(betData[BET_RISK_INDEX]);
                Bet bet = new Bet(value, risk);

                String userName = betData[USER_NAME_INDEX];
                int userAge = Integer.parseInt(betData[USER_AGE_INDEX]);
                User user = new User(userName, userAge);

                betDao.add(bet);
                userDao.add(user);

                System.out.println(bet);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Please, enter correct data");
            }
        }
    }
}
