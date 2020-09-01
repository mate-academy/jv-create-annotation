package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Ingect;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Ingect
    private BetDao betDao;
    @Ingect
    private UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String enteredData = scanner.nextLine();
            if (enteredData.equalsIgnoreCase("q")) {
                return;
            }
            String[] data = enteredData.trim().split(" ");
            Bet bet = null;
            User user = null;
            try {
                String login = data[0];
                String password = data[1];
                user = new User(login, password);
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Ви ввели неправильні дані, спробуйте ще раз!");
                continue;
            }
            betDao.addBetToStorage(bet);
            userDao.addUserToStorage(user);
            System.out.println(user == null ? null : user.toString());
            System.out.println(bet == null ? null : bet.toString());

        }
    }
}
