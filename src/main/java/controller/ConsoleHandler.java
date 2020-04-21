package controller;

import dao.BetDao;
import dao.PersonDao;
import java.util.Scanner;
import lib.Inject;
import model.Bet;
import model.Person;

public class ConsoleHandler {

    @Inject
    private BetDao betDao;

    @Inject
    private PersonDao personDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] input = userInput.split(" ");
                int value = Integer.parseInt(input[0]);
                double risk = Double.parseDouble(input[1]);
                String name = input[2];
                int id = Integer.parseInt(input[3]);
                betDao.add(new Bet(value, risk));
                personDao.add(new Person(id, name));
            } catch (NumberFormatException e) {
                System.out.println("Wrong input!");
            }
        }
    }
}
