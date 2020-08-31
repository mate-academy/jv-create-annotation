package core.basesyntax;

import controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Введіть ставку та ризик вашої ставки, а також ім'я користовача та кількість його очок");
        handler.handle();
    }
}
