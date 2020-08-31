package core.basesyntax.console;

import core.basesyntax.dao.BetUserDao;
import core.basesyntax.dao.BetUserDaoImplementation;
import core.basesyntax.db.Storage;
import core.basesyntax.model.BetUser;
import java.util.Scanner;

public class UserConsoleHandler {
    BetUserDao betUserDao = new BetUserDaoImplementation();
    Scanner scanner = new Scanner(System.in);

    public void userConsole() {

        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("q")) {
                return;
            }
            BetUser betUser = null;
            try {
                String[] betUserData = line.split(" ");
                String name = betUserData[0];
                String surname = betUserData[1];
                int age = Integer.valueOf(betUserData[2]);
                betUser = new BetUser(name, surname, age);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("incorrect data");
            }
            Storage.betUsers.add(betUser);
            System.out.println(betUser);
        }
    }
}
