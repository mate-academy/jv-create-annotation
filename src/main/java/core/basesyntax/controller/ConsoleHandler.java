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
                return;
            }
            Bet bet = null;
            User user = null;
            try {
                String[] betData = command.split(" ");
                String name = betData[0];
                String lastName = betData[1];
                int age = Integer.parseInt(betData[2]);
                if (age < 18) {
                    throw new RuntimeException("You are not allowed to bet");
                }
                int value = Integer.parseInt(betData[3]);
                double risk = Double.parseDouble(betData[4]);
                bet = new Bet(value, risk);
                user = new User(name, lastName, age);
            } catch (NumberFormatException e) {
                System.out.println("Enter valid data");
            }
            betDao.add(bet);
            userDao.add(user);
            System.out.println(bet == null ? null : bet.toString());
            System.out.println(user == null ? null : user.toString());
        }
    }
}
