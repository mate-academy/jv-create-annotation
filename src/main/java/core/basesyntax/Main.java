package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.exception.AbsentDaoAnnotatedFieldException;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException,
            AbsentDaoAnnotatedFieldException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Enter credentials in a given order: "
                + "1: username, 2: userId, 3: value, 4: risk.");
        handler.handle();
    }
}
