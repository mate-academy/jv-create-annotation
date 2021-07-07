package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    UserDao userDao = new UserDaoImpl();
    BetDao betDao = new BetDaoImpl();

    public void handleUsers() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("To add new USER please enter 'name login password'"
                        + " or 'q' if you don't want to do it:");
                String action = scanner.nextLine();
                if (action.equalsIgnoreCase("q")) {
                    return;
                }
                User newUser = null;
                try {
                    String[] dataStringsUser = action.split(" ");
                    String login = dataStringsUser[0];
                    String name = dataStringsUser[1];
                    String password = dataStringsUser[2];
                    newUser = new User(name, login, password);
                    addBets(scanner, newUser);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Please enter correct data");
                }
                if (newUser != null) {
                    userDao.addNewUser(newUser);
                } else {
                    System.out.println("Error, user don't added try again");
                }
            }
        }
    }

    private void addBets(Scanner scanner, User user) {
        while (true) {
            System.out.println("To add new BET please enter 'bet risk'"
                    + " or 'q' if dont want to do it:");
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("q")) {
                return;
            }
            Bet newBet = null;
            try {
                String[] dataStringsBet = action.split(" ");
                int id = user.getUserId();
                int betValue = Integer.parseInt(dataStringsBet[0]);
                double riskValue = Double.parseDouble(dataStringsBet[1]);
                newBet = new Bet(id, betValue, riskValue);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please enter correct bet data");
            }
            if (newBet != null) {
                betDao.add(newBet);
            } else {
                System.out.println("Error, bet don't added try again");
            }
        }
    }
}

