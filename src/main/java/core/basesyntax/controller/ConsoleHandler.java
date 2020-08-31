package core.basesyntax.controller;

import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] betData = command.split(" ");
                int amount = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                Bet bet = new Bet(amount, risk);
                System.out.println(bet.toString());
            } catch (NumberFormatException e) {
                System.out.println("Please enter numbers in an appropriate format.");
            }
        }
    }
}
