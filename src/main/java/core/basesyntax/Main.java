package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Type your name and age, bet and risk. PRESS 'q' FOR EXIT");
        ConsoleHandler handler = new ConsoleHandler();
        handler.handle();
    }
}
