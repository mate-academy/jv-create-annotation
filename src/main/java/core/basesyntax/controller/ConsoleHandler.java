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
    private static UserDao userDao;
    @Inject
    private static BetDao betDao;

    public static void input() {
        try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String command = bufferReader.readLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                String name = data[0];
                int id = Integer.parseInt(data[1]);
                int betValue = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                User user = new User(name, id);
                Bet bet = new Bet(betValue, risk);
                userDao.add(user);
                betDao.add(bet);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Wrong input data!");
        }
    }
}
