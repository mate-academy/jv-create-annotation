package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ControllerHandler {
    private static final String QUIT = "q";
    private static final int BET = 0;
    private static final int RISK = 1;
    private static final int NAME = 0;
    private static final int NICK_NAME = 1;
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        try {
            String userComand = scanner.nextLine();
            String[] splitData = userComand.split(" ");
            User user = new User(splitData[NAME], splitData[NICK_NAME]);
            userDao.add(user);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Please enter a correct data");
        }

        System.out.println("Your name was added to Data Base");
        System.out.println("Enter your bet and risk or enter 'q' to exit");

        while (true) {
            String command = scanner.nextLine();
            if (command.trim().equalsIgnoreCase(QUIT)) {
                return;
            }
            try {
                String[] betsData = command.split(" ");
                int betValue = Integer.parseInt(betsData[BET]);
                double riskValue = Double.parseDouble(betsData[RISK]);
                Bet bet = new Bet(betValue, riskValue);
                betDao.add(bet);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException("Please enter a correct data");
            }
        }
    }
}
