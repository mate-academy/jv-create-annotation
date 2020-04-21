package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CatDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Cat;
import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private BetDao betDao;

    @Inject
    private CatDao catDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }

            Bet bet = null;
            Cat cat = null;
            try {
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                String catName = String.valueOf(data[2]);
                bet = new Bet(value, risk);
                cat = new Cat(catName);
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct data");
            }
            betDao.add(bet);
            catDao.add(cat);

            System.out.println(bet == null ? null : bet.toString());
            System.out.println(cat == null ? null : cat.toString());
        }
    }
}
