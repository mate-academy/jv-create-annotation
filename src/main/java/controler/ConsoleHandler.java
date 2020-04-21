package controler;

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
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            String[] personBetData = command.split(" ");
            Bet bet = null;
            Person person = null;
            try {
                String name = personBetData[0];
                int value = Integer.parseInt(personBetData[1]);
                double risk = Double.parseDouble(personBetData[2]);
                bet = new Bet(value, risk);
                person = new Person(bet, name);
            } catch (NumberFormatException e) {
                System.out.println("Будьласка введіть коеректні данні");
            }
            if (bet != null) {
                betDao.add(bet);
                System.out.println(bet.toString());
            }
            if (person != null) {
                personDao.add(person);
                System.out.println(person.toString());
            }
        }
    }
}
