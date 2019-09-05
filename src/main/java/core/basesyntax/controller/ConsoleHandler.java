package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    static BetDao betDao ;

    public static void handle() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
                try {
                    String[] data = command.split(" ");
                    int value = Integer.parseInt(data[0]);
                    double risk = Double.parseDouble(data[1]);
                    Bet bet = new Bet(value,risk);
                    BetDao betDao = new BetDaoImpl();
                    betDao.add(bet);
                } catch (Exception e) {
                    System.out.println("Not correct data");
                }
        }
    }
}