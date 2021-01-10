package controller;

import bd.Storage;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.HorseDao;
import dao.HorseDaoImpl;
import java.util.Scanner;
import java.util.stream.Collectors;
import model.Bet;
import model.Horse;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();
    HorseDao horseDao = new HorseDaoImpl();

    public void handler() {

        Scanner scanner = new Scanner(System.in);
        String [] input;

        while (true) {
            String consoleInput = scanner.nextLine();
            if (consoleInput.equals("q")) {
                System.out.println(Storage.bets.stream()
                        .distinct().collect(Collectors.toList()).toString());
                System.out.println(Storage.horses.stream()
                        .map(Horse::getName).distinct().collect(Collectors.toList()).toString());
                return;
            }
            try {
                input = consoleInput.split(" ");
                betDataProcessing(input[0], input[1]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Wrong input data");
            }
            horseDataProcessing(input[2], scanner);
            System.out.println("You can do your next bet, risk and horse or q for exit");
        }
    }

    private void betDataProcessing(String betInput, String riskInput) {
        Bet bet = new Bet(Integer.parseInt(betInput), Double.parseDouble(riskInput));
        if (bet.getValue() != 0 && bet.getRisk() != 0) {
            betDao.add(bet);
        }
        Storage.bets.addAll(betDao.getAll());
        System.out.print(bet.toString());
    }

    private void horseDataProcessing(String nameHorse, Scanner scanner) {
        Horse horse = new Horse(nameHorse);
        if (horse.getName().length() == 0) {
            throw new RuntimeException("Name of horse is expected");
        }
        horseDao.add(horse);
        Storage.horses.addAll(horseDao.getAll());
        System.out.println(" Horse " + horse.getName());
        System.out.println("You can change hose. "
                + "If you want change horse - please, input new name,"
                + "if not - please, input 'n'");
        String consoleInput;
        consoleInput = scanner.nextLine();
        if (!(consoleInput.equals("n"))) {
            horse.changeName(consoleInput);
            System.out.println("name horse was changed " + horse.getName());
        }
    }
}
