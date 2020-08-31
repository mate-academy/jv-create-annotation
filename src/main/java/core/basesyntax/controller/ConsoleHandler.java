package core.basesyntax.controller;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.Dao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {

    Dao betDao = new BetDaoImpl();
    Dao userDao = new UserDaoImpl();

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
                int value = Integer.parseInt(betData[2]);
                double risk = Double.parseDouble(betData[3]);
                bet = new Bet(value, risk);
                user = new User(name, lastName);
            } catch (NumberFormatException e) {
                System.out.println("Ви вели некоректні дані.");
            }
            betDao.add(bet);
            userDao.add(user);
            System.out.println(user == null ? null : user.toString());
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
