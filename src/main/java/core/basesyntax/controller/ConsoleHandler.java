package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void handle() {
        System.out.println("Введіть ім'я та фамілію користувача");
        Scanner scanner = new Scanner(System.in);
        User user;
        while (true) {
            String[] userData = scanner.nextLine().split(" ");
            try {
                String name = userData[0];
                String surname = userData[1];
                user = new User(name, surname);
                break;
            } catch (Exception e) {
                System.out.println("Будь ласка введіть коректні дані");
            }
        }
        userDao.add(user);
        System.out.println(user.toString());

        System.out.println("Введіть value та risk для вашої ставки");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Будь ласка введіть коректні дані");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }

    }
}
