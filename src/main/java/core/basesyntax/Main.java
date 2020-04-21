package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler;
        try {
            handler = new Injector(new Factory()).getInstance(ConsoleHandler.class);
        } catch (NoSuchMethodException | IllegalAccessException
                | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Create bets. Signature: value risk");
        handler.createBet();
        System.out.println("Create users. Signature: login password");
        handler.createUser();
    }

}
