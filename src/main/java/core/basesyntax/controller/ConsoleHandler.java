package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.GamerDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Gamer;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private static BetDao betDao;
    @Inject
    private static GamerDao gamerDao;

    public static void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                int age = Integer.parseInt(data[0]);
                if (age < 21) {
                    System.out.printf("You are not allowed to be here\n");
                    continue;
                }
                String nickname = data[1];
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                Gamer gamer = new Gamer(age, nickname);
                gamerDao.add(gamer);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Wrong data");
            }
        }
    }
}

