package core.basesyntax.controller;

import core.basesyntax.DAO.BetDao;
import core.basesyntax.DAO.CasinoDAO;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Casino;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private static BetDao betDao;

    @Inject
    private static CasinoDAO casinoDAO;

    public static void handle(){
        Casino casino = new Casino("Bet", true);
        casinoDAO.add(casino);
        try(Scanner scanner = new Scanner(System.in)){
            while (true){
                String command = scanner.nextLine();
                if(command.equals("0")){
                    return;
                }
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            }
        } catch (Exception e){
            System.out.println("Wrong input format!");
        }
    }
}
