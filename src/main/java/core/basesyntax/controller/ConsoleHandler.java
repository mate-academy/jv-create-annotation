package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();
    UserDao userDao = new UserDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                System.out.println(userDao.getAllUsers());
                System.out.println(betDao.getAllBets());
                return;
            }
            Bet bet;
            User user;
            try {
                String[] betData = command.split(" ");
                String name = betData[0];
                String surname = betData[1];
                int age = Integer.parseInt(betData[2]);
                if (age < 18) {
                    throw new IllegalArgumentException("You are to young to do bets");
                }
                int value = Integer.parseInt(betData[3]);
                double risk = Double.parseDouble(betData[4]);
                bet = new Bet(value, risk);
                user = new User(name, surname, age);
                betDao.add(bet);
                userDao.add(user);
            } catch (NumberFormatException e) {
                System.out.println("You have entered unparsable data. "
                        + "Try again or enter 'q' to quit");
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("You've entered too little information. "
                        + "Try again or enter 'q' to quit");
                continue;
            }
            System.out.println(bet.toString() + " " + user.toString());
            System.out.println("Keep betting or enter 'q' to quit");
        }
    }
}
