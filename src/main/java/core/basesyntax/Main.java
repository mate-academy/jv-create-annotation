package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Please, input your username and password and write "
                + "'Start play' to start playing");
        handler.handlePlayer();
        System.out.println("Please input your value and risk");
        handler.handle();
    }
}
