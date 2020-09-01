package core.basesyntax;

import java.util.Scanner;

public class ConsoleHandler {
    private BetDao betDao;
    private UserDao userDao;

    public ConsoleHandler(BetDao betDao, UserDao userDao) {
        this.betDao = betDao;
        this.userDao = userDao;
    }

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
