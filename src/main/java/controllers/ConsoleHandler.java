package controllers;

import dao.BetDao;
import dao.CustomerDao;
import java.util.Scanner;
import lib.Inject;
import models.Bet;

public class ConsoleHandler {

    private static final int VALUE_INDEX = 0;
    private static final int RISK_INDEX = 1;
    @Inject
    private static BetDao betDao;
    @Inject
    private static CustomerDao customerDao;


    public static void handle() {
        System.out.println("Чтобы добавить ставку, введите \n"
                + "сумму и риск через пробел");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[VALUE_INDEX]);
                double risk = Double.parseDouble(data[RISK_INDEX]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Wrong input");
        }
    }
}
