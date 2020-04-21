package controller;

import dao.BetDao;
import dao.PersonDao;
import java.util.Scanner;
import lib.Inject;
import model.Bet;
import model.Person;

public class ConsoleHandler {

    private int value;
    private double risk;
    private String name;
    private int id;

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
