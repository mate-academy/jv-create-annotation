package core.basesyntax.controler;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.lib.Dao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Human;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Dao
    private HumanDao humanDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            Human human = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                String name = betData[2];
                int year = Integer.parseInt(betData[3]);
                bet = new Bet(value, risk);
                human = new Human(name, year);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Некоректні дані");
            }
            betDao.add(bet);
            humanDao.add(human);
            System.out.println(bet == null || human == null ? null : bet.toString() + human.toString());
        }
    }
}
