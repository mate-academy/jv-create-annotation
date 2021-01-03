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

    public void handleBet() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter right information, please!");
                continue;
            }
            betDao.add(bet);

            System.out.println(bet == null ? null : bet.toString());
        }
    }

    public void handleUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            User user = null;
            try {
                String[] userData = command.split(" ");
                String username = userData[0];
                String password = userData[1];
                user = new User(username, password);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter right information, please!");
                continue;
            }
            userDao.add(user);
            System.out.println(user == null ? null : user.toString());
        }
    }
}
