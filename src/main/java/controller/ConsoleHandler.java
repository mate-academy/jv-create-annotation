package controller;

import dao.BetDao;
import dao.UserDao;

import java.util.Scanner;

import lib.Inject;
import models.Bet;
import models.User;

public class ConsoleHandler {
    @Inject
    private static BetDao betDao;
    @Inject
    private static UserDao userDao;

    public static void handle() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
                User user = new User(name, age);
                userDao.add(user);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Данные введены некорректно" + e);
            }
        }
    }
}



