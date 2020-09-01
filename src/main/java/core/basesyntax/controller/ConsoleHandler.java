package core.basesyntax.controller;

import core.basesyntax.dao.bet.BetDao;
import core.basesyntax.dao.user.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String INVALID_DATA_MESSAGE = "Invalid data, try one more time";
    private static final String COMMANDS_MESSAGE
            = "Enter 'u'-> add user, 'b'-> add bet or 'q' -> exit";

    @Inject
    BetDao betDao;

    @Inject
    UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(COMMANDS_MESSAGE);
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.equalsIgnoreCase("q")) {
                return;
            }
            if (line.equalsIgnoreCase("u")) {
                System.out.println("Enter user login and pass in format 'login pass'");
                line = scanner.nextLine();
                addUser(line);
            }
            if (line.equalsIgnoreCase("b")) {
                System.out.println("Enter in format 'value risk'");
                line = scanner.nextLine();
                addBet(line);
            }
            System.out.println(COMMANDS_MESSAGE);
        }
    }

    private void addBet(String line) {
        String[] enteredData;
        Bet bet;
        enteredData = line.split(" ");
        try {
            bet = new Bet(Integer.parseInt(enteredData[0]),
                    Double.parseDouble(enteredData[1]));
            betDao.add(bet);
            System.out.println(bet.toString() + " has been added to storage!");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println(INVALID_DATA_MESSAGE);
        }
    }

    private void addUser(String line) {
        String[] enteredData;
        User user;
        enteredData = line.split(" ");
        try {
            user = new User(enteredData[0], enteredData[1]);
            userDao.add(user);
            System.out.println(user.toString() + " has been created!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(INVALID_DATA_MESSAGE);
        }
    }
}
