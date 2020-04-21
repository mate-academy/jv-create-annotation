package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Inject;
import core.basesyntax.models.Bet;
import core.basesyntax.models.User;
import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        Bet bet = null;
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            try {
                String[] values = input.split(" ");
                int value = Integer.parseInt(values[0]);
                double risk = Double.parseDouble(values[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter correct numbers, please!");
            }
            betDao.add(bet);
            userDao.add(new User("Герман", 30));
        }
        System.out.println(Factory.getBetDao().getAllBets());
        System.out.println(Factory.getUserDao().getAllUsers());

    }
}
