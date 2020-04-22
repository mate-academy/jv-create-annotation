package core.basesyntax.controller;

import core.basesyntax.dao.ClientDao;
import core.basesyntax.dao.CreditDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Client;
import core.basesyntax.model.Credit;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private CreditDao creditDao;
    @Inject
    private ClientDao clientDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }

            Client client;
            Credit credit;
            try {
                String[] creditData = command.split(" ");
                String fullName = creditData[0];
                double debt = Double.parseDouble(creditData[1]);
                int loan = Integer.parseInt(creditData[2]);
                double interestRate = Double.parseDouble(creditData[3]);
                client = new Client(fullName, debt);
                credit = new Credit(loan, interestRate);
            } catch (Exception e) {
                System.out.println("Invalid data. Try again:");
                continue;
            }
            clientDao.add(client);
            creditDao.add(credit);
            System.out.println(client);
            System.out.println(credit);
        }
    }
}
