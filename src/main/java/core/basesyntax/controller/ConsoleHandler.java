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
    private Scanner scanner;

    public ConsoleHandler() {
        scanner = new Scanner(System.in);
    }

    public void handle() {
        while (true) {
            System.out.println("For registration press 'r' "
                    + "\nFor create bet press 'b'"
                    + "\nFor quit press 'q'");
            String command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case "r":
                    handleUser();
                    break;
                case "b":
                    handleBet();
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Please enter correct command");
            }
        }
    }

    public void handleBet() {
        System.out.println("Input betValue and risk (Example: \"22 2.2\")");
        String command = scanner.nextLine();
        Bet bet;
        try {
            String[] betData = command.split(" ");
            bet = new Bet(Integer.parseInt(betData[0]), Double.parseDouble(betData[1]));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter correct data");
            return;
        }
        betDao.add(bet);
        System.out.println("Your bet is: " + bet);
        System.out.println(betDao.getAll());
    }

    public void handleUser() {
        System.out.println("Input username and age (Example: \"testUser 22\")");
        String command = scanner.nextLine();
        User user;
        try {
            String[] userData = command.split(" ");
            user = new User(userData[0], Integer.parseInt(userData[1]));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter correct data");
            return;
        }
        userDao.add(user);
        System.out.println("Your name is: " + user.getName() + ". Your age is " + user.getAge());
        System.out.println(userDao.getAll());
    }
}
