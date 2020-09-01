package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.impl.BetDaoImpl;
import core.basesyntax.dao.impl.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final int BET_VALUE_DATA = 0;
    private static final int BET_RISK_DATA = 1;
    private static final int USER_NAME_DATA = 2;
    private static final int USER_AGE_DATA = 3;

    private BetDao betDao = new BetDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public void handle() {
        Bet newBet;
        User newUser;
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Input your (int){bet value} (double){bet risk} "
                + "(String){user name} (int){user age}");
        while (!(input = scanner.nextLine()).equals("q")) {
            try {
                String[] parameters = input.split(" ");
                newBet = new Bet(Integer.parseInt(parameters[BET_VALUE_DATA]),
                        Double.parseDouble(parameters[BET_RISK_DATA]));
                newUser = new User(parameters[USER_NAME_DATA],
                        Integer.parseInt(parameters[USER_AGE_DATA]));
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Your data is not correct");
                continue;
            }
            betDao.add(newBet);
            userDao.add(newUser);
            System.out.println(newBet);
            System.out.println(newUser);
            System.out.println("Input one more bet parameters or q for exit");
        }
    }
}
