import controller.ConsoleHandler;
import lib.Injector;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Add users. Like: email accNumber");
        handler.createUser();
        System.out.println("Add bets. Like: value risk");
        handler.createBet();
    }
}
