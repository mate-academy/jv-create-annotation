package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserdaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();
    UserDao userDao = new UserdaoImpl();
    Scanner scanner = new Scanner(System.in);

    public void handle() {

        while (true) {
            Bet bet;
            User user;
            System.out.println("Enter your bet bellow: ...");
            String betInfo = scanner.nextLine();
            if (betInfo.equalsIgnoreCase("q")) {
                return;
            }
            System.out.println("Enter your name and age...");
            String userInfo = scanner.nextLine();
            try {
                String[] betData = betInfo.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong input values!");
                continue;
            }
            try {
                String[] userData = userInfo.split(" ");
                String name = userData[0];
                int age = Integer.parseInt(userData[1]);
                if (age <= 21) {
                    System.out.println("You're too young for gambling!!!");
                    return;
                }
                user = new User(name, age, bet);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Age value inappropriate!");
                continue;
            }
            betDao.addBet(bet);
            userDao.addUser(user);
            System.out.println(bet.toString());
        }
    }
}

