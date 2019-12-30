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
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                int value = Integer.parseInt(data[2]);
                double risk = Double.valueOf(data[3]);
                User user = new User(name, age);
                userDao.add(user);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Entered data is incorrect");
            }
        }
    }
}
