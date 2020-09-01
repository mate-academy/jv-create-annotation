package core.basesyntax;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, NoSuchImplementationException {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Enter your name, id and value, risk of your bet");
        System.out.println("You can enter a set of bets,"
                + " but don't forget about user data before each bet");
        consoleHandler.handle();
    }
}
