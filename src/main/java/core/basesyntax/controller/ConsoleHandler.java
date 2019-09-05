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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login: ");
        String login = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println("Set value and risk");
        String command = scanner.nextLine();
        if (command.equals("0")) {
            return;
        }
        try {
            String[] data = command.split(" ");
            int value = Integer.parseInt(data[0]);
            double risk = Double.parseDouble(data[1]);
            Bet bet = new Bet(value, risk);
            User user = new User(login, password);
            userDao.add(user);
            betDao.add(bet);
        } catch (Exception e) {
            System.out.println("");
        }
    }
}
