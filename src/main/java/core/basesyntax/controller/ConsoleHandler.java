package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    public void handleUsers() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("To add new USER please enter 'name login password'"
                        + " or 'q' if you don't want to do it:");
                String action = scanner.nextLine();
                if (action.equalsIgnoreCase("q")) {
                    return;
                }
                try {
                    String[] dataStringsUser = action.split(" ");
                    String login = dataStringsUser[0];
                    String name = dataStringsUser[1];
                    String password = dataStringsUser[2];
                    User newUser = new User();
                    newUser.setName(name);
                    newUser.setLogin(login);
                    newUser.setPassword(password);
                    addBets(scanner, newUser);
                    UserDao newUserDao = new UserDaoImpl();
                    newUserDao.addNewUser(newUser);
                } catch (Exception e) {
                    System.out.println("Please enter correct data");
                }

            }
        }
    }

    public void addBets(Scanner scanner, User user) {
        while (true) {
            System.out.println("To add new BET please enter 'bet risk'"
                     + " or 'q' if dont want to do it:");
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] dataStringsBet = action.split(" ");
                Bet newBet = new Bet();
                int id = user.getUserId();
                int betValue = Integer.parseInt(dataStringsBet[0]);
                double riskValue = Double.parseDouble(dataStringsBet[1]);
                newBet.setUserId(id);
                newBet.setValue(betValue);
                newBet.setRisk(riskValue);
                BetDao betDao = new BetDaoImpl();
                betDao.add(newBet);
            } catch (Exception e) {
                System.out.println("Please enter correct bet data");
            }
        }
    }
}

