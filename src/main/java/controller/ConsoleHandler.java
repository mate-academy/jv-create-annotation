package controller;

import bd.Storage;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.HorseDao;
import dao.HorseDaoImpl;
import java.util.Scanner;
import model.Bet;
import model.Horse;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();
    HorseDao horseDao = new HorseDaoImpl();

    public void handler() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String consoleInput = scanner.nextLine();
            if (consoleInput.equals("q")) {
                return;
            }
            try {
                String [] input = consoleInput.split(" ");
                Bet bet = new Bet(Integer.parseInt(input[0]), Double.parseDouble(input[1]));
                if (bet.getValue() != 0 && bet.getRisk() != 0) {
                    betDao.add(bet);
                }
                Horse horse = new Horse(input[2]);
                Storage.bets.addAll(betDao.getAll());
                System.out.print(bet.toString());
                System.out.println("Horse " + horse.getName());
                System.out.println("You can change hose. "
                        + "If you want change horse - please, input new name,"
                        + "if not - please, input 'n'");
                consoleInput = scanner.nextLine();
                if (!(consoleInput.equals("n"))) {
                    horseDao.changeName(horse, consoleInput);
                }
                System.out.println("name horse was changed " + horse.getName());
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Wrong input data");
            }
        }
    }
}
