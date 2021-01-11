package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String PRES_FOR_EXIT = "q";
    private static final String SEPARATOR = " ";
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void handle() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String command = scan.nextLine();
            Bet bet = null;
            if (command.equalsIgnoreCase(PRES_FOR_EXIT)) {
                return;
            }
            try {
                String[] betData = command.split(SEPARATOR);
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter correct data");
            }
            if (bet != null) {
                betDao.add(bet);
            }
            System.out.println(bet);
        }
    }
}
