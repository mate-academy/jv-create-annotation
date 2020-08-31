package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private BetDao betDao;
    private UserDao userDao;

    public ConsoleHandler() {
        this.betDao = new BetDaoImpl();
        this.userDao = new UserDaoImpl();
    }

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String command = scanner.nextLine();
                if (command.equals("quit")) {
                    scanner.close();
                    return;
                }
                if (command.equals("bet")) {
                    System.out.println("Enter 'value' and 'risk'");
                    command = scanner.nextLine();
                    String[] str = command.split(" ");
                    int value = Integer.parseInt(str[0]);
                    double risk = Double.parseDouble(str[1]);
                    Bet bet = new Bet(value, risk);
                    betDao.add(bet);
                    scanner.close();
                    System.out.println(betDao.getAll());
                    return;
                }
                if (command.equals("user")) {
                    System.out.println("Enter 'login' and 'email'");
                    command = scanner.nextLine();
                    String[] str = command.split(" ");
                    String login = str[0];
                    String email = str[1];
                    User user = new User(login, email);
                    userDao.add(user);
                    scanner.close();
                    System.out.println(userDao.getAll());
                    return;
                }
            } catch (IllegalArgumentException e) {
                throw new NumberFormatException(e.getMessage());
            }
        }
    }
}
