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
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            User user = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
                System.out.println("Введите имя и Ваш возраст: ");
                command = scanner.nextLine();
                String[] userData = command.split(" ");
                String name = userData[0];
                int age = Integer.parseInt(userData[1]);
                if (age >= 18) {
                    user = new User(name, age);
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Пожалуйста, введите корректные данные!");
                continue;
            }
            betDao.add(bet);
            userDao.add(user);
            System.out.println(user == null ? "Простите, но людям не достигшим 18 лет запрещено "
                    + "играть в азартные игры"
                    : "Игрок " + user.getName() + " сделал ставку: " + "\n"
                    + bet.toString());
        }
    }
}
