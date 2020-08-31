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

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                scanner.close();
                return;
            }
            Bet bet = null;
            User user = null;
            try {
                String[] userAndBetData = command.split(" ");
                String name = userAndBetData[0];
                int age = Integer.parseInt(userAndBetData[1]);
                if (age < 18) {
                    throw new IllegalArgumentException();
                }
                int value = Integer.parseInt(userAndBetData[2]);
                double risk = Double.parseDouble(userAndBetData[3]);
                bet = new Bet(value, risk);
                user = new User(name, age);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please, input correct data");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("We take bets only from adults, sorry");
                continue;
            }
            userDao.add(user);
            betDao.add(bet);
            System.out.println(user.toString());
            System.out.println(bet.toString());
        }
    }
}
