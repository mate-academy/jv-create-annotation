package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private BetDao betDao = new BetDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        Bet bet = null;
        User user = null;
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            try {
                String[] betAndUserData = input.split(" ");
                int value = Integer.parseInt(betAndUserData[0]);
                double risk = Double.parseDouble(betAndUserData[1]);
                bet = new Bet(value, risk);
                String name = betAndUserData[2];
                int age = Integer.parseInt(betAndUserData[3]);
                user = new User(name, age);
                betDao.add(bet);
                userDao.add(user);
            } catch (NumberFormatException e) {
                System.out.println("Enter correct numbers, please!" + e);
                continue;

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter correct information, please!" + e);
                continue;
            }
            System.out.println(bet.toString());
            System.out.println(user.toString());
        }
    }
}
