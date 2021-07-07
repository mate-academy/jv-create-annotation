package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.lib.InjectHuman;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Human;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static BetDao betDao;

    @InjectHuman
    private static HumanDao humanDao;

    public static void handle() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                String name = data[2];
                Bet bet = new Bet(value, risk);
                Human human = new Human(name);
                betDao.add(bet);
                humanDao.add(human);
            }
        } catch (Exception e) {
            System.out.println("Данные введены некорректно");
        }
    }
}
