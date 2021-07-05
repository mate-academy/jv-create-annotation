package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.GamblerDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Gambler;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static BetDao betDao;
    @Inject
    private static GamblerDao gamblerDao;

    public static void handle() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                try {
                    String[] data = command.split(" ");
                    int value = Integer.parseInt(data[0]);
                    double risk = Double.parseDouble(data[1]);
                    String firstName = data[2];
                    int id = Integer.parseInt(data[3]);
                    Bet bet = new Bet(value, risk);
                    Gambler user = new Gambler(firstName, id);
                    betDao.add(bet);
                    gamblerDao.add(user);
                } catch (Exception e) {
                    System.out.println("Данные введены некорректно");
                }
            }
        }
    }
}
