package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.library.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    BetDao betDao;
    @Inject
    UserDao userDao;

    public void handle() {
        System.out.println("Enter your name, surname and age, "
                + "your bet value and risk for it");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            User user = null;
            try {
                String[] inputData = command.split(" ");
                String name = inputData[0];
                String surname = inputData[1];
                int age = Integer.parseInt(inputData[2]);
                int value = Integer.parseInt(inputData[3]);
                double risk = Double.parseDouble(inputData[4]);
                user = new User(name, surname, age);
                bet = new Bet(risk, value);
                userDao.add(user);
                betDao.add(bet);
                System.out.println(user);
                System.out.println(bet);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong parameters");
            }
        }
    }
}
