package core.basesyntax;

import core.basesyntax.controller.ControllerHandler;

public class Main {
    public static void main(String[] args) {
        ControllerHandler controllerHandler = new ControllerHandler();
        System.out.println("Please input data");
        controllerHandler.handle();
    }
}
