package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImp;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImp;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    public void handle() {
        UserDao userDao = new UserDaoImp();
        BetDao betDao = new BetDaoImp();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("go")) {
                System.out.println("break a leg!");
                return;
            }
            User user;
            Bet bet;
            try {
                String[] betData = command.split(" ");
                if (betData.length == 4) {
                    String login = betData[0];
                    String password = betData[1];
                    int value = Integer.parseInt(betData[2]);
                    double risk = Double.parseDouble(betData[3]);
                    user = new User(login, password);
                    bet = new Bet(value, risk);
                    userDao.add(user);
                    betDao.add(bet);
                    System.out.println(user.toString() + "\n" + bet.toString());
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please, enter correct data!");
            }
        }
    }
}
