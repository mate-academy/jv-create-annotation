package core.basesyntax.controller;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.impl.BetDaoImpl;
import core.basesyntax.dao.impl.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private Dao<Bet> betDao = new BetDaoImpl();
    private Dao<User> userDao = new UserDaoImpl();

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
                String userName = betData[2];
                bet = new Bet(value, risk);
                user = new User(userName);
                System.out.println(bet.toString() + " " + user.getName());
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Введены некорректные данные. "
                        + "Пример корректных данных:100 0.1 name");
                continue;
            }
            betDao.add(bet);
            userDao.add(user);
        }
    }
}
