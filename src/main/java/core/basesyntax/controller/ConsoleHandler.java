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
                String[] betData = command.split(" ");
                String login = betData[0];
                int value = Integer.parseInt(betData[1]);
                double risk = Double.parseDouble(betData[2]);
                bet = new Bet(value, risk);
                user = new User(login, value);
            } catch (NumberFormatException e) {
                System.out.println("Please input correct data.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please input all data.");
            }
            betDao.add(bet);
            userDao.add(user);
            System.out.println(bet == null ? null : bet.toString());
            System.out.println(user == null ? null : user.toString());
        }
    }
}
