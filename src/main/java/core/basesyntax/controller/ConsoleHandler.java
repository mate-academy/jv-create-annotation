package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final int POSITION_OF_VALUE = 0;
    private static final int POSITION_OF_RISK = 1;
    private static final int POSITION_OF_NAME = 2;
    private static final int POSITION_OF_AGE = 3;

    @Inject
    private static BetDao betDao;
    @Inject
    private static UserDao userDao;

    public static void handle() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[POSITION_OF_VALUE]);
                double risk = Double.parseDouble(data[POSITION_OF_RISK]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
                String name = data[POSITION_OF_NAME];
                int age = Integer.parseInt(data[POSITION_OF_AGE]);
                User user = new User(name, age);
                userDao.add(user);
            }
        } catch (Exception e) {
            System.out.println("Incorrect data.");
        }
    }
}
