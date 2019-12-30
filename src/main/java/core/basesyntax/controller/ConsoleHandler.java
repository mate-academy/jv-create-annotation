package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CasinoDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Casino;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private static BetDao betDao;

    @Inject
    private static CasinoDao casinoDao;

    public static void handle() {
        Casino casino = new Casino("Bet", true);
        casinoDao.add(casino);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please imput your bet and risk (FE: 100 0.01) \n "
                    + "or 0 ,if you want exit");
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    System.out.println(casinoDao.getAll());
                    System.out.println(betDao.getAll());
                    return;
                }
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            }
        } catch (Exception e) {
            System.out.println("Wrong input format!");
        }
    }
}
