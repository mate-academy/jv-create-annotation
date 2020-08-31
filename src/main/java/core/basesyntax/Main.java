package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input value and risk for your bet:");
        ConsoleHandler handler = new ConsoleHandler();
        handler.handle();
    }
}
