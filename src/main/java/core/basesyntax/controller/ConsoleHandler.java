package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;

import java.util.Scanner;

public class ConsoleHandler {

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
                try {
                    String[] data = command.split(" ");
                    int value = Integer.parseInt(data[0]);
                    double risk = Double.parseDouble(data[1]);
                    String userName = data[2];
                    Bet bet = new Bet(value, risk);
                    User user = new User(userName);
                    betDao.add(bet);
                    userDao.add(user);
                } catch (Exception e) {
                    System.out.println("Данные введены некорректно");
                }
            }
        }
    }
}
