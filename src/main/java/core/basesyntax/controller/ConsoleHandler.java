package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;
import core.basesyntax.mylibrary.Inject;
import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static BetDao betDao;
    @Inject
    private static PersonDao personDao;

    public static void userInterface() {
        try {
            while (true) {
                System.out.println("Please, input personal dates in format {name} {age} {income}\n"
                        + "input '0' to exit");

                Scanner scannerPerson = new Scanner(System.in);
                String commandPerson = scannerPerson.nextLine();
                if (commandPerson.equals("0")) {
                    return;
                }
                String[] dataPerson = commandPerson.split(" ");
                Person newPerson = new Person(dataPerson[0],
                        Integer.parseInt(dataPerson[1]),
                        Integer.parseInt(dataPerson[2]));
                personDao.add(newPerson);
                System.out.println("Input your bet dates in format {value} {risk}\n"
                        + "input '0' to exit");
                Scanner scannerBets = new Scanner(System.in);
                String commandBets = scannerBets.nextLine();
                if (commandBets.equals("0")) {
                    return;
                }

                String[] betData = commandBets.split(" ");
                Bet newBet = new Bet(Integer.parseInt(betData[0]),Double.parseDouble(betData[1]));
                betDao.add(newBet);

                System.out.println(personDao.getAll().toString());
                System.out.println(betDao.getAll().toString());
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
