package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class MainApp {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Input data separated with spaces: name age bet risk");
        handler.handle();
    }
}
