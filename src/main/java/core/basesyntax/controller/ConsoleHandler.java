package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static BetDao betDao;

    @Inject
    private static UserDao userDao;

    static public void handle() {
        int count = 0;
        int entriesNumber = 2;
        while (count < entriesNumber) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                String name = data[2];
                String surName = data[3];
                Bet bet = new Bet(value, risk);
                User user = new User(name, surName);
                BetDao betDao = new BetDaoImpl();
                UserDao userDao = new UserDaoImpl();
                betDao.add(bet);
                userDao.addUser(user);
            } catch (Exception e) {
                System.out.println("Данные введены некорректно.");
            }
            count++;
        }
    }
}
