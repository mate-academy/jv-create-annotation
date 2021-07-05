package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private BetDao betDao;
    private UserDao userDao;

    public ConsoleHandler() {
        this.betDao = new BetDaoImpl();
        this.userDao = new UserDaoImpl();
    }

    public void handleBet() {
        String command;
        while (!(command = readInput()).equals("quit")) {
            try {
                String[] str = command.split(" ");
                int value = Integer.parseInt(str[0]);
                double risk = Double.parseDouble(str[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
                System.out.println(betDao.getAll());
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong input!\nTry to enter data in format '[value] [risk]'");
            }
        }
    }

    public void handleUser() {
        String command;
        while (!(command = readInput()).equals("quit")) {
            try {
                String[] str = command.split(" ");
                String login = str[0];
                String email = str[1];
                User user = new User(login, email);
                userDao.add(user);
                System.out.println(userDao.getAll());
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong input!\nTry to enter data in format '[login] [email]'");
            }
        }
    }

    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
