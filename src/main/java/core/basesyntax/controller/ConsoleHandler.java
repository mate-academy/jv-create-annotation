package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Inject
    private UserDao userDao;
    @Inject
    private BetDao betDao;

    public void userHandle() {
        System.out.println("Enter login and password for User, please!!!");
        while (true) {
            String consoleData = SCANNER.nextLine();
            if (consoleData.equals("q")) {
                return;
            }
            String[] arrayData = consoleData.split(" ");
            try {
                String login = arrayData[0];
                String password = arrayData[1];
                User user = new User(login, password);
                userDao.addUser(user);
                System.out.println(userDao.getAll().toString());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter right parameters, please!!!");
            }
        }
    }

    public void betHandle() {
        System.out.println("Enter value and risk for Bet, please!!!");
        while (true) {
            String consoleData = SCANNER.nextLine();
            if (consoleData.equals("q")) {
                return;
            }
            try {
                String[] arrayData = consoleData.split(" ");
                int value = Integer.parseInt(arrayData[0]);
                double risk = Double.parseDouble(arrayData[1]);
                Bet bet = new Bet(value, risk);
                betDao.addBet(bet);
                System.out.println(betDao.getAll().toString());
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter right parameters, please!!!");
            }
        }
    }
}
