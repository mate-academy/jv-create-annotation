package controller;

import dao.BetDao;
import dao.HorseDao;
import java.util.Scanner;
import lib.Inject;
import model.Bet;
import model.Horse;

public class ConsoleHandler {
    private static final String exit = "q";
    @Inject
    BetDao betDao;
    @Inject
    HorseDao horseDao;

    public void handler() {

        Scanner scanner = new Scanner(System.in);
        String [] input;

        while (true) {
            String consoleInput = scanner.nextLine();
            if (consoleInput.equals(exit)) {
                return;
            }
            try {
                input = consoleInput.split(" ");
                betDataProcessing(input[0], input[1]);
                horseDataProcessing(input[2]);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                throw new NumberFormatException("Wrong input data");
            }
            System.out.println("You can do your next bet, risk and horse or q for exit");
        }
    }

    private void betDataProcessing(String betInput, String riskInput) {
        Bet bet = new Bet(Integer.parseInt(betInput), Double.parseDouble(riskInput));
        if (bet.getValue() != 0 && bet.getRisk() != 0) {
            betDao.add(bet);
        }
        System.out.print(bet.toString());
    }

    private void horseDataProcessing(String nameHorse) {
        Horse horse = new Horse(nameHorse);
        if (horse.getName().length() == 0) {
            throw new RuntimeException("Name of horse is expected");
        }
        horseDao.add(horse);
        System.out.println(" Horse " + horse.getName());
    }
}
