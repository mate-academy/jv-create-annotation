package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.library.Inject;
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
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);

                String firstName = betData[2];
                String lastNmae = betData[3];
                user = new User(firstName, lastNmae);
            } catch (NumberFormatException e) {
                System.out.println("Enter correct data");
            }

            betDao.add(bet);
            userDao.add(user);

            System.out.println(bet == null ? null : bet.toString());
            System.out.println(user == null ? null : user.toString());
        }
    }
}
