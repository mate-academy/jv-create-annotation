package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.GamerDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Gamer;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private GamerDao gamerDao;

    public void handle() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String command = sc.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            Gamer gamer = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                String nameGamer = betData[2];
                bet = new Bet(value, risk);
                gamer = new Gamer(nameGamer);
            } catch (NumberFormatException e) {
                System.out.println("input correct data please -- DIGITS");
            } catch (Exception e) {
                System.out.println("input please 2 variable - value and risk");
            }
            if (bet != null) {
                betDao.add(bet);
                gamerDao.add(gamer);
            }
            System.out.println(betDao.getAll().toString());
        }
    }
}
