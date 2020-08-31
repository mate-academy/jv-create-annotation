package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        System.out.println("Введіть ваше ім'я, призвіще, "
                + "сумму та ризик для вашої ставки через пробіл.\n"
                + "Щоб завершити роботу програми натисніть 'q'.");
        consoleHandler.handle();
    }
}
