package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.models.Bet;
import core.basesyntax.models.User;
import core.basesyntax.service.Splitter;
import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        Splitter splitter = new Splitter();
        System.out.println("Enter your login and password to make a bet!");
        String userData = scanner.nextLine();
        String[] splitedUser = splitter.split(userData);
        userDao.save(new User(splitedUser[0],
                splitedUser[1]));

        while (true) {
            System.out.println("Please, enter your bet value and risk!");
            String betData = scanner.nextLine();
            try {
                String[] splitedBet = splitter.split(betData);
                betDao.save(new Bet(Integer.parseInt(splitedBet[0]),
                        Double.parseDouble(splitedBet[1])));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Wrong input data!");
            }
            System.out.println(betDao.getAll().toString());
            System.out.println(userDao.getAll().toString());
        }

    }
}
