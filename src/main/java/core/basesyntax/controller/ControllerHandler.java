package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ControllerHandler {
    public static final String INVALID_INPUT_ARGS_MESSAGE =
            "Please, make sure your input data meets requirements";
    public static String INPUT = new Scanner(System.in).nextLine();
    private static final String IGNORE_CASE = "exit";
    private static final String TOO_YOUNG_MESSAGE =
            "Looks like you're a bit too young for the service!";
    private static final String TOO_OLD_MESSAGE =
            "Looks like you've already token enough risks in your life!";
    private static final int VALID_AGE_FROM = 18;
    private static final int VALID_AGE_TO = 70;
    private static final UserDao USER_DAO = new UserDaoImpl();
    private int age = 0;

    public void handle() {
        while (true) {
            if (commandExit()) {
                return;
            }
            try {
                age = Integer.parseInt(INPUT);
            } catch (NumberFormatException exception) {
                inputCheckFailed(INVALID_INPUT_ARGS_MESSAGE, exception);
            }
            if (age < VALID_AGE_FROM) {
                checkArgsFailed(TOO_YOUNG_MESSAGE);
            } else if (age >= VALID_AGE_TO) {
                checkArgsFailed(TOO_OLD_MESSAGE);
            } else {
                System.out.println("Looks like you've passed the age test!");
            }
            System.out.println("Please, input your login for authorisation "
                    + "or register in our system with a new one:");
            INPUT = new Scanner(System.in).nextLine();
            if (commandExit()) {
                return;
            }
            User user;
            String login = INPUT;
            User.loginCheck(login);
            if (User.exists(login)) {
                user = USER_DAO.getUser(login);
            } else {
                user = new User(login, age);
                USER_DAO.addUser(user);
            }
            System.out.println("To create a new bet, please, "
                    + "type its value and risk coefficient in. "
                    + "Example: \"100 - 4.5\"\n"
                    + "Your turn to type it in: ");
            INPUT = new Scanner(System.in).nextLine();
            if (commandExit()) {
                return;
            }
            BetDao betDao = new BetDaoImpl(user);
            Bet bet = Bet.parseBet(INPUT);
            betDao.addBet(bet);
            System.out.println("Success! Here is your bet: " + bet.toString());
            INPUT = new Scanner(System.in).nextLine();
        }

    }

    public static void checkArgsFailed(String message) {
        throw new IllegalArgumentException(message);
    }

    public static void inputCheckFailed(String message, Exception exception) {
        throw new IllegalArgumentException(message, exception);
    }

    private boolean commandExit() {
        return INPUT.equalsIgnoreCase(IGNORE_CASE);
    }
}
