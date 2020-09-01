import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler
                = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("To make a bet enter [value] [risk]\nFor exit enter 'quit'");
        handler.handleBet();

        System.out.println("To register enter [login] [password]\nFor exit enter 'quit'");
        handler.handleUser();
    }
}
