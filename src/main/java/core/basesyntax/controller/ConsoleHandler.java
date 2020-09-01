package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private BetDao betDao = new BetDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int value;
            while (true) {
                System.out.println("Enter value:");
                try {
                    value = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid data. Enter number");
                }
            }
            double risk;
            while (true) {
                System.out.println("Enter risk:");
                try {
                    risk = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid data. Enter number");
                }
            }
            Bet bet = new Bet(value, risk);
            betDao.add(bet);
            System.out.println(bet);
            System.out.println("Do you want to enter another bet? Yes(enter 'y') or no(enter 'n')");
            if (scanner.nextLine().equalsIgnoreCase("n")) {
                return;
            }
        }
    }
}
