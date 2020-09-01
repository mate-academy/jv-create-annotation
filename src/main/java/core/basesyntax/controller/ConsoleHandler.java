package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();
    UserDao userDao = new UserDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }
            User user = null;
            Bet bet = null;

            try {
                String[] betAndUserData = input.split(" ");
                String userName = betAndUserData[0];
                int userAge = Integer.parseInt(betAndUserData[1]);
                if (userAge < 18) {
                    System.out.println("You are too young to place bets, go back to school!");
                    continue;
                }
                user = new User(userName, userAge);
                int value = Integer.parseInt(betAndUserData[2]);
                double risk = Double.parseDouble(betAndUserData[3]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Input data is incorrect");
            }

            userDao.addUser(user);
            betDao.addBet(bet);

            System.out.println(Storage.users);
            System.out.println(Storage.bets);
        }
    }
}
