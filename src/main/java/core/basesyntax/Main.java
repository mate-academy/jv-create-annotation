package core.basesyntax;

import core.basesyntax.controller.ControllerHandler;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ControllerHandler controllerHandler = (ControllerHandler)
                Injector.getInstance(ControllerHandler.class);
        System.out.println("Please input data");
        controllerHandler.handleBet();
        System.out.println("Please input user");
        controllerHandler.handleUser();
    }
}
