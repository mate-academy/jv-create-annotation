package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHandler {
    @Inject
    BetDao betDao;
    @Inject
    UserDao userDao;

    public void handle() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter your name and id");
            String userInfo = reader.readLine();
            String[] userData = userInfo.split(" ");
            userDao.add(new User(userData[0], Integer.parseInt(userData[1])));
            while (true) {
                System.out.println("Enter value and risk for your bet");
                String betInfo = reader.readLine();
                if (betInfo.equals("q")) {
                    break;
                }
                String[] betData = betInfo.split(" ");
                betDao.add(new Bet(Integer.parseInt(betData[0]), Double.parseDouble(betData[1])));
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read data", e);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Please enter correct data", e);
        }
        System.out.println(userDao.getAll());
        System.out.println(betDao.getAll());
    }
}
