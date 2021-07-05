package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Введите value и risk для вашей ставки:");
        handler.handle();
    }
}
