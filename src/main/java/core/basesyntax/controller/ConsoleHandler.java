package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int value = 0;
            while (value == 0) {
                System.out.println("Enter value:");
                try {
                    value = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid data. Enter number");
                }
            }
            double risk = 0;
            while (risk == 0) {
                System.out.println("Enter risk:");
                try {
                    risk = Double.parseDouble(scanner.nextLine());
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
