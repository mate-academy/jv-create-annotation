package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CustomDaoClass;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private static BetDao betDao;
    @Inject
    private static CustomDaoClass customDao;
    public static void handle() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("0")) {
                return ;
            }
            try {
                String[] data = input.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);

                betDao.add(new Bet(value, risk));
                customDao.add(new Bet(value, risk));
            } catch (Exception e) {
                System.out.println("Wrong input");
            }
        }
    }
}
