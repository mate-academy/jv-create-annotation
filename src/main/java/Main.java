import controller.ConsoleHandler;
import java.lang.reflect.InvocationTargetException;
import lib.Injector;

public class Main {
    public static void main(String [] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("Please, input your bet, risk and name of horse"
                + " separated by a space (example: 1 1.1 Lola)");
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        consoleHandler.handler();
    }
}
