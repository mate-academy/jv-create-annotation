package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class MainApp {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Welcome to the bet application!");
        handler.handle();
    }
}
