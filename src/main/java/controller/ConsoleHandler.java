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
        int value = 0;
        double risk = 0;
        String name = null;
        int id = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] input = userInput.split(" ");
                value = Integer.parseInt(input[0]);
                risk = Double.parseDouble(input[1]);
                name = input[2];
                id = Integer.parseInt(input[3]);
            } catch (NumberFormatException e) {
                System.out.println("Wrong input!");
            }
            betDao.add(new Bet(value, risk));
            personDao.add(new Person(id, name));
        }
    }
}
