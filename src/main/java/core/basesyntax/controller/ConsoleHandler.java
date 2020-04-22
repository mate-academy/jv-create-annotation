package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;

    @Inject
    private PersonDao personDao;
    // Too many places

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Input value and risk for your bet");
            String command = scanner.nextLine();
            String name = scanner.nextLine();
            personDao.addName(name);
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Invalid data was input");
            }
            betDao.add(bet);
            System.out.println(personDao);
            System.out.println(bet == null ? null : bet.toString());
        }
    }

    public BetDao getAll() {
        return betDao;
    }
}
