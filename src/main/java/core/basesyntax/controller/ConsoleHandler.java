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
            Bet bet;
            User user;
            try {
                String[] inputData = command.split(" ");
                String name = inputData[0];
                int id = Integer.parseInt(inputData[1]);
                int value = Integer.parseInt(inputData[2]);
                double risk = Double.parseDouble(inputData[3]);
                user = new User(name, id);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Write correct data");
                continue;
            }
            betDao.add(bet);
            userDao.add(user);
            System.out.println(user == null ? null : ((bet != null)
                    ? (user.toString() + " " + bet.toString()) : null));
        }
    }
}
