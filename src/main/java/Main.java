import controller.ConsoleHandler;
import exception.NoDaoImplementException;
import java.lang.reflect.InvocationTargetException;
import lib.Injector;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, NoDaoImplementException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Add users. Like: email accNumber");
        handler.createUser();
        System.out.println("Add bets. Like: value risk");
        handler.createBet();
    }
}
