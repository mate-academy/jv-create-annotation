package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.impl.BetDaoImpl;
import core.basesyntax.dao.impl.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;

import java.util.Scanner;

public class ConsoleHandler {
    private UserDao userDao = new UserDaoImpl();
    private BetDao betDao = new BetDaoImpl();

    public void handle() {
        System.out.println("Please register new User(name,email,password)");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[] userData = command.split(" ");
        User user = new User(userData[0], userData[1], userData[2]);
        userDao.addUser(user);
        while (true) {
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            try {
                System.out.println("Please add a bet(value, risk)");
                command = scanner.nextLine();
                String[] betDate = command.split(" ");
                int value = Integer.parseInt(betDate[0]);
                double risk = Double.parseDouble(betDate[1]);
                Bet bet = new Bet(value, risk);
                betDao.addBet(bet);
                userDao.addBetToUser(user, bet);
                System.out.println("Enter \"q\" for quit");
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please input the correct values");
            }
        }
    }
}
