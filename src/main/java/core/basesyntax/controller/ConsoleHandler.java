package core.basesyntax.controller;

import core.basesyntax.exception.InvalidCommandException;
import core.basesyntax.exception.UserExistException;
import core.basesyntax.service.CommandService;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class ConsoleHandler {
    private CommandService commandService;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("-> ");
            String line = scanner.nextLine();
            String[] data = line.split(" ");
            while (true) {
                if (line.equals("/q")) {
                    return;
                }
                try {
                    commandService.execute(data);
                } catch (UserExistException e) {
                    System.out.println("This login is busy");
                } catch (InvalidCommandException e) {
                    System.out.println("There is no such command. Help - [/h]");
                }
            }










//            Bet bet = null;
//            try {
//                String[] betData = command.split(" ");
//                int value = Integer.parseInt(betData[0]);
//                double risk = Double.parseDouble(betData[1]);
//                bet = new Bet(value, risk);
//                System.out.println(bet.toString());
//            } catch (NumberFormatException | IndexOutOfBoundsException e) {
//                System.out.println("Введены некорректные данные. Пример корректных данных:100 0.1");
//                continue;
//            }
//            betDao.add(bet);
        }
    }

    private void outputCommands() {
        String s = " ----------------- Commands ----------------- \n"
                + "| [/l login password] - authorization        |\n"
                + "| [/r login password age] - registration     |\n"
                + "| [/h] - help                                |\n"
                + "| [/q] - quit                                |\n"
                + " ------------------------------------------";
        System.out.println(s);
    }
}
