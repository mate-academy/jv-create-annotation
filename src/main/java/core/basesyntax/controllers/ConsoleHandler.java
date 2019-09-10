package core.basesyntax.controllers;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.models.Bet;
import core.basesyntax.models.User;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private static BetDao betDao;

    @Inject
    private static UserDao userDao;

    public static void handle() {
        System.out.println("Введіть bet щоб додавати ставки, user щоб додавати користувачів" +
                "\nабо 0 щоб завершити:");
        Scanner input = new Scanner(System.in);
        String command = null;
        while (true) {
            command = input.nextLine();
            if (command.equals("bet")) {
                readBets(input);
            } else if (command.equals("user")) {
                readUsers(input);
            } else if (command.equals("0")) {
                return;
            } else {
                System.out.println("Incorrect command");
            }
        }
    }

    private static void readBets(Scanner input) {
        System.out.println("Введіть через пробіл суму та ризик щоб додати ставку" +
                "\nабо 0 щоб завершити додавати ставки:");
        String subCommand = null;
        while (true) {
            subCommand = input.nextLine();
            if (subCommand.equals("0")) {
                return;
            }
            try {
                String[] betData = subCommand.split(" ");
                double value = Double.parseDouble(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                betDao.add(new Bet(value, risk));

            } catch (Exception e) {
                System.out.println("Incorrect command or bet data");
            }
        }
    }

    private static void readUsers(Scanner input) {
        System.out.println("Введіть через пробіл ім'я та пароль щоб додати юзера" +
                "\nабо 0 щоб завершити додавати юзерів:");
        String subCommand = null;
        while (true) {
            subCommand = input.nextLine();
            if (subCommand.equals("0")) {
                return;
            }
            try {
                String[] userData = subCommand.split(" ");
                String name = userData[0];
                String password = userData[1];
                userDao.add(new User(name, password));
            } catch (Exception e) {
                System.out.println("Incorrect command or user data");
            }
        }
    }

}
