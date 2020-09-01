package core.basesyntax.model.controller;

import core.basesyntax.model.dao.BetDao;
import core.basesyntax.model.dao.UserDao;
import core.basesyntax.model.lib.Inject;
import core.basesyntax.model.model.Bet;
import core.basesyntax.model.model.User;
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
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
                System.out.println("Please, enter your login and password");
                command = scanner.nextLine();
                String[] usersData = command.split(" ");
                String login = usersData[0];
                String password = usersData[1];
                user = new User(login, password, bet);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please, enter the correct information.");
                continue;
            }

            betDao.add(bet);
            userDao.add(user);
            System.out.println(user == null ? null : user.toString());
        }
    }
}
