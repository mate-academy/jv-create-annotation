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
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            User user = null;
            try {
                String[] data = command.split(" ");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                user = new User(name, age);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please, input correct data");
            }
            betDao.add(bet);
            userDao.add(user);
            System.out.println(bet == null ? "Keep betting or enter 'q' to quit"
                    : user.toString() + " " + bet.toString()
                    + "\n" + "Keep betting or enter 'q' to quit");
        }
    }
}
