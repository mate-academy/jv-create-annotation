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
            Bet bet = null;
            Person person = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);

                command = scanner.nextLine();
                String[] personInfo = command.split(" ");
                String name = personInfo[0];
                int id = Integer.parseInt(personInfo[1]);
                person = new Person(name, id);
            } catch (NumberFormatException e) {
                System.out.println("Please input the correct number");
            }
            betDao.add(bet);
            personDao.add(person);
            System.out.println(bet == null ? null : bet.toString());
            System.out.println(person == null ? null : person.toString());
        }
    }
}
