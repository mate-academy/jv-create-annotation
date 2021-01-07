package core.basesyntax.controler;

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

    public void betHandler() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] split = command.split(" ");
                int value = Integer.parseInt(split[0]);
                double risk = Double.parseDouble(split[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Будь-ласка введіть коректні дані");
            }
            betDao.addBet(bet);
            System.out.println(bet);
        }
    }

    public void userHandler() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            User user = null;
            try {
                String[] split = command.split(" ");
                String name = split[0];
                String lastname = split[1];
                user = new User(name, lastname);
            } catch (NumberFormatException e) {
                System.out.println("Будь-ласка введіть коректні дані");
            }
            userDao.addUser(user);
            System.out.println();
        }
    }
}
