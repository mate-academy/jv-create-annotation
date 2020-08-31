package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class MainApp {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Enter your name, age and bet's data (e.g. John;31;100;8.4)");
        handler.handle();
    }
}
