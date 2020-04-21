package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Inject;
import core.basesyntax.models.Bet;
import core.basesyntax.models.User;
import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        Bet bet = null;
        User user = null;
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            try {
                String[] betAndUserData = input.split(" ");
                int value = Integer.parseInt(betAndUserData[0]);
                double risk = Double.parseDouble(betAndUserData[1]);
                bet = new Bet(value, risk);
                String name = betAndUserData[2];
                int age = Integer.parseInt(betAndUserData[3]);
                user = new User(name, age);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter correct information, please!");
            }
            betDao.add(bet);
            userDao.add(user);
        }
        System.out.println(Factory.getBetDao().getAllBets());
        System.out.println(Factory.getUserDao().getAllUsers());
    }
}
