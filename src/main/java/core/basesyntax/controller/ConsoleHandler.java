package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.CustomerDao;
import core.basesyntax.dao.CustomerDaoImpl;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Customer;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private static BetDao libraryDao;

    public static void handle() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                String name = data[2];
                int id = Integer.parseInt(data[3]);
                Bet bet = new Bet(value,risk);
                libraryDao.add(bet);
                Customer customers = new Customer(name,id);
                CustomerDao cusDao = new CustomerDaoImpl();
                cusDao.add(customers);
            } catch (Exception e) {
                System.err.println("Вводите данные через пробел");
            }
        }
    }
}
