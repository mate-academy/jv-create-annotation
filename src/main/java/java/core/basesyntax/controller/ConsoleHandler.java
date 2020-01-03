package java.core.basesyntax.controller;

import java.core.basesyntax.dao.BetDao;
import java.core.basesyntax.dao.ClientDao;
import java.core.basesyntax.lib.Inject;
import java.core.basesyntax.model.Bet;
import java.core.basesyntax.model.Client;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private static BetDao betDao;
    @Inject
    private static ClientDao clientDao;

    public static void handle() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                String firstName = data[2];
                String lastName = data[3];
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                Client client = new Client(firstName, lastName);
                clientDao.add(client);
                Bet bet = new Bet(value,risk);
                betDao.add(bet);

            } catch (Exception e) {
                System.out.println("Данные введены некорректно");
            }
        }
    }
}
