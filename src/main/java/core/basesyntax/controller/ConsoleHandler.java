package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();
    UserDao userDao = new UserDaoImpl();

    public void handle() {
        handleBet(handleUser());
    }

    private User handleUser() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        user.setName(scanner.nextLine());
        System.out.println("Enter your surname");
        user.setSurname(scanner.nextLine());
        System.out.println("Enter your age");
        try {
            user.setAge(Integer.parseInt(scanner.nextLine()));
            if (user.getAge() < 18) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter acceptable age");
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("You are underage for this, try again in "
                    + (18 - user.getAge()) + " years.");
        }
        if (user.getName().equals("") || user.getSurname().equals("")) {
            throw new IllegalArgumentException("Don't try to enter empty row.");
        }
        userDao.add(user);
        return user;
    }

    private void handleBet(User user) {
        if (user == null) {
            System.out.println("You are not authorized. Login before making bets");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value and risk for your bet");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk, user);
            } catch (NumberFormatException e) {
                System.out.println("Enter valid data, please");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
            System.out.println("Keep betting or enter 'q' to quit");
        }
    }
}
