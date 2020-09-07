package core.basesyntax;

import core.basesyntax.controller.ControllerHandler;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Hello, dear user!\n"
                + "Are you ready to take risks?\n"
                + "To start with, type in your name, surname, age, "
                + "value of the bet and its risk. Example: \n"
                + "Dariia, Pikul, 24, 100, 4.5\n"
                + "For quitting type in \"exit\"");
        ControllerHandler controllerHandler = new ControllerHandler();
        controllerHandler.handle();
    }
}
