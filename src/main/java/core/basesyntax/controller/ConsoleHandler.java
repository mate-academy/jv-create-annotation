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
        User user = addUser(scanner);
        System.out.println(user);
        addBets(scanner, user);
        System.out.println(userDao.getUser(user));
        System.out.println(betDao.getAllBetsForUser(user));
    }

    private void addBets(Scanner scanner, User user) {
        while (true) {
            System.out.println("Enter value and risk for bet(enter 'q' for exit)."
                    + " For example: '10 1.5'");
            String commandBet = scanner.nextLine();
            if (commandBet.equalsIgnoreCase("q")) {
                System.out.println("Bets is over");
                return;
            }
            Bet bet = null;
            try {
                String[] betData = commandBet.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk, user);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Incorrect data. Please, try again");
            }
            if (bet != null) {
                betDao.add(bet);
                System.out.println(bet.toString());
            } else {
                System.out.println("Bet failed");
            }
        }
    }

    private User addUser(Scanner scanner) {
        while (true) {
            System.out.println("Enter your name and email."
                    + " For example: 'name email@gmail.com' (program support only gmail)");
            String commandUser = scanner.nextLine();
            User user = null;
            try {
                String[] userData = commandUser.split(" ");
                String userName = userData[0];
                String userEmail = userData[1];
                if (!userEmail.contains("@gmail.com") || userName.isEmpty()
                        || userEmail.charAt(0) == '@'
                        || userName.chars()
                        .filter(Character::isLetter)
                        .count() != userName.length()) {
                    System.out.println("Incorrect user data");
                    continue;
                }
                user = new User(userName, userEmail);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter two value");
            }
            if (user != null) {
                userDao.add(user);
                return userDao.getUser(user);
            }
            System.out.println("Incorrect user data");
        }
    }
}
