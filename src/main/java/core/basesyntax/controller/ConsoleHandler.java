package core.basesyntax.controller;

import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (true) {
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] betDate = command.split(" ");
                int value = Integer.parseInt(betDate[0]);
                double risk = Double.parseDouble(betDate[1]);
                Bet bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Please input the correct values");
            }
        }
    }
}
