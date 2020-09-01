package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final int FULLNAME_INDEX = 0;
    private static final int AGE_INDEX = 1;
    private static final int VALUE_INDEX = 2;
    private static final int RISK_INDEX = 3;
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
                String[] betData = command.split(";");
                int value = Integer.parseInt(betData[VALUE_INDEX]);
                double risk = Double.parseDouble(betData[RISK_INDEX]);
                bet = new Bet(value, risk);
                String fullname = betData[FULLNAME_INDEX];
                int age = Integer.parseInt(betData[AGE_INDEX]);
                user = new User(fullname, age, bet);
                betDao.add(bet);
                userDao.add(user);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Invalid data. Please enter your bet again.");
            }
        }
    }
}
