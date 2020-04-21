package controller;

import dao.BetDao;
import dao.PersonDao;
import lib.Inject;
import model.Bet;
import model.Person;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private PersonDao personDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (true) {
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                String name = betData[2];
                int age = Integer.parseInt(betData[3]);
                Person person = new Person(name, age);
                Bet bet = new Bet(value, risk);
                betDao.addBet(bet);
                personDao.addPerson(person);
                System.out.println(bet.toString() + " " + person.toString());
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Невірно введені дані.");
            }
            command = scanner.nextLine();
        }
    }
}
