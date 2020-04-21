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

    public void createBet() {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                break;
            }
            Bet bet = null;
            try {
                String[] params = command.split(" ");
                bet = new Bet(Integer.parseInt(params[0]), Double.parseDouble(params[1]));
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Input correct data");
            }
            betDao.add(bet);
            System.out.println("Bet created: " + bet);
            System.out.println("Input next one or 'q' to stop");
        }
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                break;
            }
            String[] params = command.split(" ");
            if (params.length < 2) {
                System.out.println("Input correct data");
                continue;
            }
            User user = new User(params[0], params[1]);
            userDao.add(user);
            System.out.println("User created: " + user);
            System.out.println("Input next one or 'q' to stop");
        }
    }
}
