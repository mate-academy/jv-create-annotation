package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String NEW_USER = "n";
    private static final String NEW_BET = "b";
    private static final String QUIT_APP = "q";
    @Inject
    BetDao betDao;
    @Inject
    UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        User visitor = null;
        System.out.println("Enter 'n' to create a new user or 'q' to quit application: ");
        String command = checkValidStartCommand(scanner);
        while (!command.equalsIgnoreCase(QUIT_APP)) {
            if (!isValidCommand(command)) {
                System.out.println("Unsupported command!");
            }
            if (command.equalsIgnoreCase(NEW_USER)) {
                visitor = createNewVisitor(scanner);
            }
            if (visitor == null && command.equalsIgnoreCase(NEW_BET)) {
                System.out.println("Minimum user information in appropriate format "
                        + "must be provided to be sure you are allowed to make debts");
            } else if (command.equalsIgnoreCase(NEW_BET) && visitor.isLegalGambling()) {
                System.out.println(createNewBet(visitor, scanner));
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
        while (!(command.equalsIgnoreCase(NEW_USER) || command.equalsIgnoreCase(QUIT_APP))) {
            System.out.println("Invalid option. Please, enter 'n' to create a new user "
                                + "or 'q' to quit application: ");
            command = scanner.nextLine();
        }
        return command;
    }

    private boolean isValidCommand(String command) {
        return (command.equalsIgnoreCase(NEW_USER)
                || command.equalsIgnoreCase(NEW_BET)
                || command.equalsIgnoreCase(QUIT_APP));
    }

    private User createNewVisitor(Scanner scanner) {
        System.out.println("Please, input some general information about you, "
                            + "so we could accept and save your bets");
        System.out.println("Enter your name and age");
        String command = scanner.nextLine();
        String[] userData = command.split(" ");
        User visitor = null;
        try {
            String name = userData[0];
            int age = Integer.parseInt(userData[1]);
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

    private String createNewBet(User visitor, Scanner scanner) {
        System.out.println("Please, input value and risk for your bet");
        String command = scanner.nextLine();
        String[] betData = command.split(" ");
        Bet bet = null;
        try {
            int value = Integer.parseInt(betData[0]);
            double risk = Double.parseDouble(betData[1]);
            bet = new Bet(value, risk);
            betDao.add(bet);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException message) {
            System.out.println("Please, input appropriate data");
        }
        return bet == null ? "You've made a null bet"
                : String.format("Your bet has been accepted: %s", bet.toString());
    }
}
