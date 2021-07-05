package core.basesyntax.consoler;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;
import java.util.Scanner;

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
                String[] dataPerson = command.split(" ");
                String namePerson = dataPerson[0];
                int agePerson = Integer.parseInt(dataPerson[1]);
                int valueBet = Integer.parseInt(dataPerson[2]);
                double riskBet = Double.parseDouble(dataPerson[3]);
                person = new Person(namePerson, agePerson);
                bet = new Bet(valueBet, riskBet);

            } catch (NumberFormatException e) {
                System.out.println("Data entered incorrectly");
            }
            betDao.add(bet);
            personDao.add(person);
            System.out.println((person == null) ? null : person.toString());
            System.out.println((bet == null) ? null : bet.toString());

        }
    }
}
