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
        while (true) {
            String input = new Scanner(System.in).nextLine();
            if (input.equals("")) {
                return;
            }
            try {
                String[] inputs = input.split(" ");
                int sum = Integer.valueOf(inputs[0]);
                double interest = Double.valueOf(inputs[1]);
                Bet bet = new Bet(sum, interest);
                betDao.add(bet);
                if (inputs[2].contains("@") && inputs[2].contains(".")) {
                    gamblerDao.add(new Gambler(inputs[2]));
                } else {
                    System.out.println("При вводе электронного адреса допущена ошибка.");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Данные введены некорректно.");
            }
        }
    }
}
