package core.basesyntax;

import core.basesyntax.controller.ControllerHandler;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Hello, dear user!\n"
                + "Are you ready to take risks?\n"
                + "Let's take a look at your age. Type it in here: ");
        ControllerHandler controllerHandler = new ControllerHandler();
        controllerHandler.handle();
    }
}
