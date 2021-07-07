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
        while (true) {
            User user = null;
            Bet bet = null;
            System.out.println("Enter your name, surname, value and risk of your bet");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }
            String[] data = input.split(" ");
            try {
                String name = data[0];
                String surname = data[1];
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                user = new User(name, surname);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct data");
            }
            if (user != null && bet != null) {
                userDao.add(user);
                betDao.add(bet);
                System.out.println(user.toString());
                System.out.println(bet.toString());
            }
        }
    }
}
