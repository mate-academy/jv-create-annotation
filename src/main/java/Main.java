import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException {
        //ConsoleHandler handler = new ConsoleHandler();
        ConsoleHandler handler = (ConsoleHandler) new Injector().getInstance(ConsoleHandler.class);
        System.out.println("Enter yours login, password, value, risk. Push ENTER! "
                + "After should write GO");
        handler.handle();

    }
}
