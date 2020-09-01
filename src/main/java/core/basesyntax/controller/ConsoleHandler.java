package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;

    @Inject
    private UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        User user;
        Bet bet;

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }

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

                userDao.addUser(user);
                betDao.addBet(bet);

                System.out.println(userDao.getAllUsers());
                System.out.println(betDao.getAllBets());
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Input data is incorrect");
            }

        }
    }
}
