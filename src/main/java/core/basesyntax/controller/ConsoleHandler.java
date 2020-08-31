package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String newUser = "n";
    private static final String newBet = "b";
    private static final String quitApp = "q";
    @Inject
    BetDao betDao;
    @Inject
    UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        User visitor = null;
        System.out.println("Enter 'n' to create a new user or 'q' to quit application: ");
        String command = checkValidStartCommand(scanner);
        while (!command.equalsIgnoreCase(quitApp)) {
            if (!isValidCommand(command)) {
                System.out.println("Unsupported command!");
            }
            if (command.equalsIgnoreCase(newUser)) {
                visitor = newVisitor(scanner);
            }
            if (command.equalsIgnoreCase(newBet) && userDao.isLegalGambling(visitor)) {
                System.out.println(newBet(visitor, scanner));
            }
            System.out.println("\nEnter 'n' to create a new user, 'b' to make a bet "
                                + "or 'q' to quit application: ");
            command = scanner.nextLine();
        }
        System.out.println(userDao.getAllGamblers().toString());
        System.out.println(betDao.getAll().toString());
    }

    private String checkValidStartCommand(Scanner scanner) {
        String command = scanner.nextLine();
        while (!(command.equalsIgnoreCase(newUser) || command.equalsIgnoreCase(quitApp))) {
            System.out.println("Invalid option. Please, enter 'n' to create a new user "
                                + "or 'q' to quit application: ");
            command = scanner.nextLine();
        }
        return command;
    }

    private boolean isValidCommand(String command) {
        return (command.equalsIgnoreCase(newUser)
                || command.equalsIgnoreCase(newBet)
                || command.equalsIgnoreCase(quitApp));
    }

    private User newVisitor(Scanner scanner) {
        System.out.println("Please, input some general information about you, "
                            + "so we could accept and save your bets");
        System.out.println("Enter your name and age");
        String command = scanner.nextLine();
        String[] userDate = command.split(" ");
        User visitor = null;
        try {
            String name = userDate[0];
            int age = Integer.parseInt(userDate[1]);
            visitor = new User(name, age);
            userDao.saveAsGambler(visitor);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException message) {
            System.out.println("Please, input appropriate data");
        }
        System.out.println(visitor == null
                ? "Unfortunately, provided information is not applicable for correct processing"
                : "Your data has been successfully processed");
        return visitor;
    }

    private String newBet(User visitor, Scanner scanner) {
        System.out.println("Please, input value and risk for your bet");
        String command = scanner.nextLine();
        String[] betData = command.split(" ");
        Bet bet = null;
        try {
            int value = Integer.parseInt(betData[0]);
            double risk = Double.parseDouble(betData[1]);
            bet = new Bet(value, risk);
            userDao.makeBet(visitor, bet);
            betDao.add(bet);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException message) {
            System.out.println("Please, input appropriate data");
        }
        System.out.println(bet == null ? "You've made a null bet" : "Your bet has been accepted.");
        return String.format("Your current bets are: %s", visitor.getUserBets().toString());
    }
}
