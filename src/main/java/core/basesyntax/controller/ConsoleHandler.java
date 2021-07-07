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

    public void handleBet() {
        String command;
        while (!(command = getCommand()).equalsIgnoreCase("q")) {
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
                System.out.println(bet);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter correct data");
            }
        }
    }

    public void handleUser() {
        String command;
        while (!(command = getCommand()).equalsIgnoreCase("q")) {
            try {
                String[] userData = command.split(" ");
                String name = userData[0];
                String password = userData[1];
                User user = new User(name, password);
                userDao.add(user);
                System.out.println(user);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter correct data");
            }
        }
    }

    private String getCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
