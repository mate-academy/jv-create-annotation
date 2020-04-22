package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        Bet bet = null;
        User user = null;
        while (true) {
            System.out.println("Введите Ваши name и age, а также value и risk для вашей ставки");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            String[] data = command.split(" ");
            try {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                user = new User(name, age);
                bet = new Bet(value, risk);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Пожалуйста, введите корректные данные");
            }
            if (user != null && bet != null) {
                userDao.add(user);
                betDao.add(bet);
                System.out.println(bet.toString());
                System.out.println(user.toString());
            }
        }
    }
}


