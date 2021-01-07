package core.basesyntax;

import core.basesyntax.controller.ControllerHandler;

public class Main {
    public static void main(String[] args) {
        ControllerHandler controllerHandler = new ControllerHandler();
        System.out.println("Enter your Bet and Risk");
        controllerHandler.handle();
    }
}
