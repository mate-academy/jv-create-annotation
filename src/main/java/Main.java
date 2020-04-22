import controller.ConsoleHandler;
import exception.DaoNotExistsException;
import java.lang.reflect.InvocationTargetException;
import lib.Injector;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            DaoNotExistsException, InstantiationException, IllegalAccessException {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Enter your name, age, value and risk for your bet : ");
        consoleHandler.handle();
    }
}
