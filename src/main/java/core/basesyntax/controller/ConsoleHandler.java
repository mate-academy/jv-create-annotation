package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    BetDao betDao;
    @Inject
    UserDao userDao;

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
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                String name = betData[2];
                bet = new Bet(value, risk);
                user = new User(name);
            } catch (NumberFormatException e) {
                System.out.println("Enter correct data please!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You forgot username!");
            }
            if (user != null) {
                userDao.addUser(user);
                betDao.add(bet);
            }
            System.out.println(userDao.getAllUsers().toString());
            System.out.println(betDao.getAll().toString());
        }
    }
}
