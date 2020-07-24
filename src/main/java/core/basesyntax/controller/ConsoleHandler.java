package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.library.Inject;
import core.basesyntax.models.Bet;
import core.basesyntax.models.User;
import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private BetDao betDao;

    @Inject
    private UserDao userDao;

    public void handler() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("quit")) {
                break;
            }
            Bet bet = null;
            User user = null;
            try {
                String[] betData = command.split(" ");
                bet = new Bet(Integer.parseInt(betData[0]),
                        Double.parseDouble(betData[1]));
                user = new User(betData[2]);
            } catch (NumberFormatException e) {
                System.out.println(
                        "Input data is invalid, "
                                + "please enter your bet amount and risk value correctly!");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : "Your command received. " + bet.toString());
            userDao.add(user);
            System.out.println(user == null ? null : "Your name received. " + user.toString());
        }
    }
}
